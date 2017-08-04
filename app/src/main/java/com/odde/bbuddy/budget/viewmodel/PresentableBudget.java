package com.odde.bbuddy.budget.viewmodel;

import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

import java.text.SimpleDateFormat;

/**
 * Created by allenwang on 2017/8/3.
 */

public class PresentableBudget implements ItemPresentationModel<Budget> {

    private String month;
    private int amount;

    @Override
    public void updateData(Budget budget, ItemContext itemContext) {
        amount = budget.getAmount();

        SimpleDateFormat simpleDate =  new SimpleDateFormat("dd/MM/yyyy");
        String s = simpleDate.format(budget.getTimeString());
        month = s;
    }

    public String getDisplayOfBudget() {
        return month + " " + amount;
    }

}
