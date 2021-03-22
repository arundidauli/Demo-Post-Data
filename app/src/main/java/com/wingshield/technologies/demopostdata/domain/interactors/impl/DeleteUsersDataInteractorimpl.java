package com.wingshield.technologies.demopostdata.domain.interactors.impl;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.domain.executor.Executor;
import com.wingshield.technologies.demopostdata.domain.executor.MainThread;
import com.wingshield.technologies.demopostdata.domain.interactors.DeleteUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.UpdateUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.base.AbstractInteractor;
import com.wingshield.technologies.demopostdata.network.ApiClient;
import com.wingshield.technologies.demopostdata.network.response.GetUserDataResponse;
import com.wingshield.technologies.demopostdata.network.services.DeleteUsersDataApiInterface;
import com.wingshield.technologies.demopostdata.network.services.UpdateUsersDataApiInterface;
import com.wingshield.technologies.demopostdata.utils.AppConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteUsersDataInteractorimpl extends AbstractInteractor {

    private final DeleteUserDataInteractor.Callback callback;
    private final JsonObject jsonObject;
    private final int id;

    public DeleteUsersDataInteractorimpl(Executor threadExecutor, MainThread mainThread, DeleteUserDataInteractor.Callback callback, JsonObject jsonObject, int id) {
        super(threadExecutor, mainThread);
        this.callback = callback;
        this.jsonObject = jsonObject;
        this.id = id;
    }

    @Override
    public void run() {

        DeleteUsersDataApiInterface deleteUsersDataApiInterface= ApiClient.getClient().create(DeleteUsersDataApiInterface.class);
        Call<GetUserDataResponse> call=deleteUsersDataApiInterface.deleteUser(AppConfig.TOKEN_ID,jsonObject,id);
        call.enqueue(new Callback<GetUserDataResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetUserDataResponse> call,@NonNull Response<GetUserDataResponse> response) {
                try {
                    callback.UserDelete(response.body().getCode());
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
