package com.odde.bbuddy.budget.api;

import com.odde.bbuddy.account.viewmodel.Account;
import com.odde.bbuddy.budget.viewmodel.Budget;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RawBudgetsApi {

    @POST("/budgets")
    Call<ResponseBody> addBudget(@Body Budget budget);

    @GET("/budgets")
    Call<List<Budget>> getAllBudget();

}
