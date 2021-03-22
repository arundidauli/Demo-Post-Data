package com.wingshield.technologies.demopostdata.domain.interactors;

import com.wingshield.technologies.demopostdata.model.Users;

import java.util.List;

public interface UpdateUserDataInteractor {

    interface Callback{
        void UpdateStatus(int code);

    }
}
