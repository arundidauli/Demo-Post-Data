package com.wingshield.technologies.demopostdata.domain.interactors;



import com.wingshield.technologies.demopostdata.model.HomeData;

import java.util.List;

public interface HomeDataInteractor {
    interface CallBack {

        void onHomeDataDownloaded(List<HomeData> homeDataList);

        void onHomeDataDownloadError();
    }
}
