package com.wingshield.technologies.demopostdata.network.services;

import com.wingshield.technologies.demopostdata.network.response.GetUserDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface GetUsersDataApiInterface {
    @Headers("Content-Type: application/json")
    @GET("users")
    Call<GetUserDataResponse> getUsersData();

}
