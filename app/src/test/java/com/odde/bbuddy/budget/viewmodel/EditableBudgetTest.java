package com.odde.bbuddy.budget.viewmodel;

import com.odde.bbuddy.budget.api.Budgets;
import com.odde.bbuddy.budget.view.BudgetsNavigation;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EditableBudgetTest {

    BudgetsNavigation mockBudgetsNavigation = mock(BudgetsNavigation.class);
    Budgets mockBudgets = mock(Budgets.class);
    EditableBudget editableBudget = new EditableBudget(mockBudgetsNavigation, mockBudgets);

    @Test
    public void add_will_navigate_to_budgets() {
        addBudget("2017-08-1", "1000");

        verify(mockBudgetsNavigation).navigate();
    }

    @Test
    public void add_will_call_domain_object_to_add() {
        addBudget("2017-08-01", "1000");

        verifyBudgetsAddBudgetWith("2017-08-01", 1000);
    }

    private void verifyBudgetsAddBudgetWith(String expectedMonth, int expectedAmount) {
        ArgumentCaptor<Budget> captor = forClass(Budget.class);
        verify(mockBudgets).addBudget(captor.capture());
        assertThat(captor.getValue().getTimeString()).isEqualTo(expectedMonth);
        assertThat(captor.getValue().getAmount()).isEqualTo(expectedAmount);
    }

    private void addBudget(String month, String amount) {
        editableBudget.setTime(month);
        editableBudget.setAmount(amount);
        editableBudget.add();
    }

}