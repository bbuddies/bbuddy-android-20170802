package com.odde.bbuddy.budget.api;

import com.odde.bbuddy.budget.viewmodel.Budget;
import com.odde.bbuddy.di.scope.ActivityScope;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@ActivityScope
public class Budgets {

    private final RawBudgetsApi rawBudgetsApi;

    @Inject
    public Budgets(RawBudgetsApi rawBudgetsApi) {
        this.rawBudgetsApi = rawBudgetsApi;
    }

    public void addBudget(Budget budget) {
        rawBudgetsApi.addBudget(budget).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
