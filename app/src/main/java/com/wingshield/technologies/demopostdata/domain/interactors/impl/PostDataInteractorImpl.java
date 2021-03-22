package com.wingshield.technologies.demopostdata.domain.interactors.impl;

import android.util.Log;

import androidx.annotation.NonNull;

import com.wingshield.technologies.demopostdata.domain.executor.Executor;
import com.wingshield.technologies.demopostdata.domain.executor.MainThread;
import com.wingshield.technologies.demopostdata.domain.interactors.PostDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.base.AbstractInteractor;
import com.wingshield.technologies.demopostdata.model.Post;
import com.wingshield.technologies.demopostdata.network.ApiClient;
import com.wingshield.technologies.demopostdata.network.services.PostDataApiInterface;
import com.wingshield.technologies.demopostdata.utils.AppConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDataInteractorImpl extends AbstractInteractor {
    private PostDataInteractor.Callback callback;

    public PostDataInteractorImpl(Executor threadExecutor, MainThread mainThread, PostDataInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        this.callback = callback;
    }

    @Override
    public void run() {

        PostDataApiInterface apiInterface= ApiClient.getClient().create(PostDataApiInterface.class);
        Call<List<Post>> postData=apiInterface.getPost();
        postData.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {

                try {
                    Log.e(AppConfig.TAG, response.toString());
                    callback.postLoaded(response.body());
                }catch (Exception e){
                    Log.e("Exception", e.getMessage());
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                    callback.onError(t.getMessage());
            }
        });

    }
}
