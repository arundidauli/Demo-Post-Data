package com.wingshield.technologies.demopostdata.domain.interactors;

import com.firebase.ui.auth.data.model.User;
import com.wingshield.technologies.demopostdata.domain.interactors.base.AbstractInteractor;
import com.wingshield.technologies.demopostdata.model.Users;

import java.util.List;

public interface LoadUserDataInteractor {

    interface Callback{
        void getUsers(List<Users> usersList);
        void onError(String message);
    }
}
