package com.wingshield.technologies.demopostdata.domain.interactors.impl;

import android.util.Log;

import androidx.annotation.NonNull;

import com.wingshield.technologies.demopostdata.domain.executor.Executor;
import com.wingshield.technologies.demopostdata.domain.executor.MainThread;
import com.wingshield.technologies.demopostdata.domain.interactors.LoadUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.base.AbstractInteractor;
import com.wingshield.technologies.demopostdata.network.ApiClient;
import com.wingshield.technologies.demopostdata.network.response.GetUserDataResponse;
import com.wingshield.technologies.demopostdata.network.services.GetUsersDataApiInterface;
import com.wingshield.technologies.demopostdata.utils.AppConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetUsersDataInteractorimpl extends AbstractInteractor {

    private final LoadUserDataInteractor.Callback callback;

    public GetUsersDataInteractorimpl(Executor threadExecutor, MainThread mainThread, LoadUserDataInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        this.callback = callback;
    }

    @Override
    public void run() {

        GetUsersDataApiInterface getUsersDataApiInterface= ApiClient.getClient().create(GetUsersDataApiInterface.class);
        Call<GetUserDataResponse> call=getUsersDataApiInterface.getUsersData();
        call.enqueue(new Callback<GetUserDataResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetUserDataResponse> call,@NonNull Response<GetUserDataResponse> response) {
                try {
                    callback.getUsers(response.body().getUsersList());

                }catch (Exception e){
                    Log.e(AppConfig.TAG,e.getMessage());
                }

            }

            @Override
            public void onFailure(@NonNull Call<GetUserDataResponse> call,@NonNull Throwable t) {
                callback.onError(t.getMessage());
            }
        });


    }
}
