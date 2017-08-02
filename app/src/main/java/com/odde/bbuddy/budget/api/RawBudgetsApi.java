package com.odde.bbuddy.budget.api;

import com.odde.bbuddy.budget.viewmodel.Budget;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RawBudgetsApi {

    @POST("/budgets")
    Call<ResponseBody> addBudget(@Body Budget budget);
}
