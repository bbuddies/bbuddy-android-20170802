package com.odde.bbuddy.budget.viewmodel;

import com.odde.bbuddy.budget.api.Budgets;
import com.odde.bbuddy.budget.view.BudgetsNavigation;
import com.odde.bbuddy.common.functional.Consumer;
import com.odde.bbuddy.di.scope.ActivityScope;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;

/**
 * Created by allenwang on 2017/8/3.
 */


@PresentationModel
@ActivityScope
public class PresentableBudgets implements HasPresentationModelChangeSupport {
    private final Budgets budgets;
    private final BudgetsNavigation budgetsNavigation;
    private final Lazy<PresentationModelChangeSupport> changeSupportLazyLoader;
    private final List<Budget> allBudgets = new ArrayList<>();

    @ItemPresentationModel(value = PresentableBudget.class)
    public List<Budget> getBudgets() {
        return allBudgets;
    }

    @Inject
    public PresentableBudgets(Budgets budgets, BudgetsNavigation budgetsNavigation, @Named("budgets") Lazy<PresentationModelChangeSupport> changeSupportLazyLoader) {
        this.budgets = budgets;
        this.budgetsNavigation = budgetsNavigation;
        this.changeSupportLazyLoader = changeSupportLazyLoader;
        refresh();
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport();
    }

    public void refresh() {
        budgets.processAllBudgets(new Consumer<List<Budget>>() {
            @Override
            public void accept(List<Budget> list) {
                allBudgets.clear();
                allBudgets.addAll(list);
                changeSupport().refreshPresentationModel();
            }
        });
    }

    public void search() {
        budgetsNavigation.navToSearch(allBudgets);
    }

    private PresentationModelChangeSupport changeSupport() {
        return this.changeSupportLazyLoader.get();
    }

}



