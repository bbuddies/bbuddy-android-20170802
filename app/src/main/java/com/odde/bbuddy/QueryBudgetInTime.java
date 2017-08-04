package com.odde.bbuddy;


import com.odde.bbuddy.budget.viewmodel.Budget;

import java.util.Date;
import java.util.List;

/**
 * Created by allenwang on 2017/8/3.
 */

public class QueryBudgetInTime {
    List<Budget> budgets;

    public QueryBudgetInTime(List<Budget> budgets){
        this.budgets = budgets;
    }

    public int query(Date startDate, Date endDate) {
        int totalAmount = 0;

        for (Budget budget : budgets) {
            Date time = budget.getTimeString();
            boolean isIn = time.after(startDate) &&
                    time.before(endDate);
            if (!isIn) { continue; }
            totalAmount += budget.getAmount();
        }

        return totalAmount;
    }


}
