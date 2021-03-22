package com.wingshield.technologies.demopostdata.presentation.ui.activities;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.model.Users;

import java.util.List;

public interface UserView {

    void getUsers(List<Users> usersList);
    void updateUser (int message);
    void deleteUser (int message);
    void insertUser (int message);

}
