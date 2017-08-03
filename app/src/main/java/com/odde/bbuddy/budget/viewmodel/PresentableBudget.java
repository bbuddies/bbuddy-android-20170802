package com.odde.bbuddy.budget.viewmodel;

import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * Created by allenwang on 2017/8/3.
 */

public class PresentableBudget implements ItemPresentationModel<Budget> {

    private String month;
    private int amount;

    @Override
    public void updateData(Budget budget, ItemContext itemContext) {
        amount = budget.getAmount();
        month = budget.getMonth();
    }

    public String getDisplayOfBudget() {
        return month + " " + amount;
    }

}
