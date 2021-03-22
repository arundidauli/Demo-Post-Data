package com.wingshield.technologies.demopostdata.presentation.presenters;


import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.domain.executor.Executor;
import com.wingshield.technologies.demopostdata.domain.executor.MainThread;
import com.wingshield.technologies.demopostdata.domain.interactors.HomeDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.impl.HomeDataInteractorImpl;
import com.wingshield.technologies.demopostdata.model.HomeData;
import com.wingshield.technologies.demopostdata.presentation.ui.activities.HomeView;

import java.util.List;

public class HomePresenter extends AbstractPresenter implements HomeDataInteractor.CallBack {
    private HomeView homeView;

    public HomePresenter(Executor executor, MainThread mainThread, HomeView homeView) {
        super(executor, mainThread);
        this.homeView = homeView;
    }



    @Override
    public void onHomeDataDownloaded(List<HomeData> homeDataList) {
        if (homeView != null) {
            homeView.setHomeData(homeDataList);
        }
    }

    @Override
    public void onHomeDataDownloadError() {

    }
}