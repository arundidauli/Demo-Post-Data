package com.wingshield.technologies.demopostdata.network.services;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.network.response.GetUserDataResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface DeleteUsersDataApiInterface {
    @Headers("Content-Type: application/json")
    @DELETE("users/{id}")
    Call<GetUserDataResponse> deleteUser(@Header("Authorization") String authHeader, @Body JsonObject jsonObject, @Path("id") int id);

}
