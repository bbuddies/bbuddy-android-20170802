package com.odde.bbuddy.budget.viewmodel;

import com.odde.bbuddy.account.viewmodel.Account;
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

    private final Lazy<PresentationModelChangeSupport> changeSupportLazyLoader;
    private final List<Budget> allBudgets = new ArrayList<>();

    @ItemPresentationModel(value = PresentableBudget.class)
    public List<Budget> getBudgets() {
        return allBudgets;
    }

    @Inject
    public PresentableBudgets(@Named("budgets") Lazy<PresentationModelChangeSupport> changeSupportLazyLoader) {
        this.changeSupportLazyLoader = changeSupportLazyLoader;
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport();
    }

    private PresentationModelChangeSupport changeSupport() {
        return this.changeSupportLazyLoader.get();
    }
}

