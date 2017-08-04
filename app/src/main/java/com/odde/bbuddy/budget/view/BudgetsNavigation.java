package com.odde.bbuddy.budget.view;

import android.app.Activity;
import android.content.Intent;

import com.odde.bbuddy.budget.viewmodel.Budget;
import com.odde.bbuddy.di.scope.ActivityScope;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

@ActivityScope
public class BudgetsNavigation {

    private final Activity activity;

    @Inject
    public BudgetsNavigation(Activity activity) {
        this.activity = activity;
    }

    public void navigate() {
        activity.finish();
    }

    public void navToSearch(List<Budget> b) {
        Intent i = new Intent();
        i.setClass(activity, BudgetsQueryByTimeActivity.class);
        i.putExtra("budget list", (Serializable) b);
        activity.startActivity(i);
    }
}
