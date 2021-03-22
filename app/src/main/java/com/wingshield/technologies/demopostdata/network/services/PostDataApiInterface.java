package com.wingshield.technologies.demopostdata.network.services;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.model.Post;
import com.wingshield.technologies.demopostdata.network.response.HomeDataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostDataApiInterface {
    @Headers("Content-Type: application/json")
    @GET("posts")
    Call<List<Post>> getPost();


}
