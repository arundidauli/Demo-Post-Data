package com.wingshield.technologies.demopostdata.domain.interactors;

import com.google.gson.JsonObject;

public interface InsertUserDataInteractor {

    interface Callback{

        void DataInsert(int status);

    }
}
