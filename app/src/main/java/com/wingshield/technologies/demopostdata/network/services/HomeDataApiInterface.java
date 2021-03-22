package com.wingshield.technologies.demopostdata.network.services;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.network.response.HomeDataResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface HomeDataApiInterface {
    @Headers("Content-Type: application/json")
    @POST("isAcceptedByUserList")
    Call<HomeDataResponse> getHomeData(@Header("X-API-KEY") String authHeader, @Body JsonObject jsonObject);


}
