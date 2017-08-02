package com.odde.bbuddy.budget.viewmodel;


import android.support.annotation.NonNull;

import com.odde.bbuddy.budget.api.Budgets;
import com.odde.bbuddy.budget.view.BudgetsNavigation;
import com.odde.bbuddy.di.scope.ActivityScope;

import org.robobinding.annotation.PresentationModel;

import javax.inject.Inject;

@PresentationModel
@ActivityScope
public class EditableBudget {

    private final BudgetsNavigation budgetsNavigation;
    private final Budgets budgets;

    @Inject
    public EditableBudget(BudgetsNavigation budgetsNavigation, Budgets budgets) {
        this.budgetsNavigation = budgetsNavigation;
        this.budgets = budgets;
    }

    private String month;
    private String amount;

    public void add() {
        budgets.addBudget(budget());
        budgetsNavigation.navigate();
    }

    @NonNull
    private Budget budget() {
        Budget budget = new Budget();
        budget.setMonth(month);
        budget.setAmount(Integer.parseInt(amount));
        return budget;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
