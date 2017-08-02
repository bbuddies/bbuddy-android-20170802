package com.odde.bbuddy.budget.api;

import android.util.Log;

import com.odde.bbuddy.budget.viewmodel.Budget;
import com.odde.bbuddy.di.scope.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class Budgets {

    @Inject
    public Budgets() { }

    public void addBudget(Budget budget) {
        Log.d("month", budget.getMonth());
        Log.d("amount", String.valueOf(budget.getAmount()));
    }
}
