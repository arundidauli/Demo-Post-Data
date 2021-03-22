package com.wingshield.technologies.demopostdata.domain.interactors.impl;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.domain.executor.Executor;
import com.wingshield.technologies.demopostdata.domain.executor.MainThread;
import com.wingshield.technologies.demopostdata.domain.interactors.UpdateUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.base.AbstractInteractor;
import com.wingshield.technologies.demopostdata.network.ApiClient;
import com.wingshield.technologies.demopostdata.network.response.GetUserDataResponse;
import com.wingshield.technologies.demopostdata.network.services.UpdateUsersDataApiInterface;
import com.wingshield.technologies.demopostdata.utils.AppConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateUsersDataInteractorimpl extends AbstractInteractor {

    private final UpdateUserDataInteractor.Callback callback;
    private final JsonObject jsonObject;
    private final int id;

    public UpdateUsersDataInteractorimpl(Executor threadExecutor, MainThread mainThread, UpdateUserDataInteractor.Callback callback, JsonObject jsonObject, int id) {
        super(threadExecutor, mainThread);
        this.callback = callback;
        this.jsonObject = jsonObject;
        this.id = id;
    }

    @Override
    public void run() {

        UpdateUsersDataApiInterface updateUsersDataApiInterface= ApiClient.getClient().create(UpdateUsersDataApiInterface.class);
        Call<GetUserDataResponse> call=updateUsersDataApiInterface.updateUser(AppConfig.TOKEN_ID,jsonObject,id);
        call.enqueue(new Callback<GetUserDataResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetUserDataResponse> call,@NonNull Response<GetUserDataResponse> response) {
                try {
                    callback.UpdateStatus(response.body().getCode());
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
