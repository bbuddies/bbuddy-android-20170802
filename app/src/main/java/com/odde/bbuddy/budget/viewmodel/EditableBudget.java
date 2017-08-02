package com.odde.bbuddy.budget.viewmodel;


import com.odde.bbuddy.di.scope.ActivityScope;

import org.robobinding.annotation.PresentationModel;

import javax.inject.Inject;

@PresentationModel
@ActivityScope
public class EditableBudget {

    @Inject
    public EditableBudget() { }
}
