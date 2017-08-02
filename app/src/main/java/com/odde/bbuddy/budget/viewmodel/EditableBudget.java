package com.odde.bbuddy.budget.viewmodel;


import android.util.Log;

import com.odde.bbuddy.budget.view.BudgetsNavigation;
import com.odde.bbuddy.di.scope.ActivityScope;

import org.robobinding.annotation.PresentationModel;

import javax.inject.Inject;

@PresentationModel
@ActivityScope
public class EditableBudget {

    private final BudgetsNavigation budgetsNavigation;

    @Inject
    public EditableBudget(BudgetsNavigation budgetsNavigation) {
        this.budgetsNavigation = budgetsNavigation;
    }

    private String month;
    private String amount;

    public void add() {
        Log.d("month", month);
        Log.d("amount", amount);
        budgetsNavigation.navigate();
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
