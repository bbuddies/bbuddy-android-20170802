package com.odde.bbuddy.budget.api;

import android.support.annotation.NonNull;

import com.odde.bbuddy.account.viewmodel.Account;
import com.odde.bbuddy.budget.viewmodel.Budget;
import com.odde.bbuddy.common.functional.Consumer;
import com.odde.bbuddy.di.scope.ActivityScope;

import java.util.List;

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

    public void processAllBudgets(final Consumer<List<Budget>>  consumer) {
        rawBudgetsApi.getAllBudget().enqueue(new Callback<List<Budget>>() {
            @Override
            public void onResponse(Call<List<Budget>> call, Response<List<Budget>> response) {
                consumer.accept(response.body());
            }

            @Override
            public void onFailure(Call<List<Budget>> call, Throwable t) {

            }
        });
    }

    @NonNull
    private Callback<ResponseBody> callbackOfAfterSuccess(final Runnable afterSuccess) {
        return new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                afterSuccess.run();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        };
    }
}
