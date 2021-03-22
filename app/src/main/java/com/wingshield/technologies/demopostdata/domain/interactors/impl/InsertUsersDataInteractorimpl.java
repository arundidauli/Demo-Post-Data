package com.wingshield.technologies.demopostdata.domain.interactors.impl;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.domain.executor.Executor;
import com.wingshield.technologies.demopostdata.domain.executor.MainThread;
import com.wingshield.technologies.demopostdata.domain.interactors.InsertUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.LoadUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.base.AbstractInteractor;
import com.wingshield.technologies.demopostdata.network.ApiClient;
import com.wingshield.technologies.demopostdata.network.response.GetUserDataResponse;
import com.wingshield.technologies.demopostdata.network.services.GetUsersDataApiInterface;
import com.wingshield.technologies.demopostdata.network.services.InsertUsersDataApiInterface;
import com.wingshield.technologies.demopostdata.utils.AppConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertUsersDataInteractorimpl extends AbstractInteractor {

    private final InsertUserDataInteractor.Callback callback;
    private final JsonObject jsonObject;


    public InsertUsersDataInteractorimpl(Executor threadExecutor, MainThread mainThread, InsertUserDataInteractor.Callback callback, JsonObject jsonObject) {
        super(threadExecutor, mainThread);
        this.callback = callback;
        this.jsonObject = jsonObject;
    }

    @Override
    public void run() {

        InsertUsersDataApiInterface getUsersDataApiInterface= ApiClient.getClient().create(InsertUsersDataApiInterface.class);
        Call<GetUserDataResponse> call=getUsersDataApiInterface.updateUser(AppConfig.TOKEN_ID,jsonObject);
        call.enqueue(new Callback<GetUserDataResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetUserDataResponse> call,@NonNull Response<GetUserDataResponse> response) {
                try {
                    callback.DataInsert(response.body().getCode());

                }catch (Exception e){
                    Log.e(AppConfig.TAG,e.getMessage());
                }

            }

            @Override
            public void onFailure(@NonNull Call<GetUserDataResponse> call,@NonNull Throwable t) {

            }
        });


    }
}
