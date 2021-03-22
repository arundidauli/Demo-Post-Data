package com.wingshield.technologies.demopostdata.domain.interactors.impl;

import android.util.Log;


import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.network.ApiClient;
import com.wingshield.technologies.demopostdata.domain.executor.Executor;
import com.wingshield.technologies.demopostdata.domain.executor.MainThread;
import com.wingshield.technologies.demopostdata.domain.interactors.HomeDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.base.AbstractInteractor;
import com.wingshield.technologies.demopostdata.network.response.HomeDataResponse;
import com.wingshield.technologies.demopostdata.network.services.HomeDataApiInterface;
import com.wingshield.technologies.demopostdata.utils.AppConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeDataInteractorImpl extends AbstractInteractor {
    private HomeDataInteractor.CallBack mCallback;
    private HomeDataApiInterface apiService;
    private JsonObject jsonObject;

    public HomeDataInteractorImpl(Executor threadExecutor, MainThread mainThread, HomeDataInteractor.CallBack callBack,JsonObject jsonObject) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.jsonObject=jsonObject;
    }


    @Override
    public void run() {
        apiService = ApiClient.getClient().create(HomeDataApiInterface.class);
        Call<HomeDataResponse> call = apiService.getHomeData(AppConfig.TOKEN_ID,jsonObject);

        call.enqueue(new Callback<HomeDataResponse>() {
            @Override
            public void onResponse(Call<HomeDataResponse> call, Response<HomeDataResponse> response) {
                try {
                    mCallback.onHomeDataDownloaded(response.body().getData());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<HomeDataResponse> call, Throwable t) {
                mCallback.onHomeDataDownloadError();
            }
        });

    }
}
