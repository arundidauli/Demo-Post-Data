package com.wingshield.technologies.demopostdata.network.services;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.network.response.GetUserDataResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface InsertUsersDataApiInterface {
    @Headers("Content-Type: application/json")
    @PATCH("users")
    Call<GetUserDataResponse> updateUser(@Header("Authorization") String authHeader, @Body JsonObject jsonObject);

}
