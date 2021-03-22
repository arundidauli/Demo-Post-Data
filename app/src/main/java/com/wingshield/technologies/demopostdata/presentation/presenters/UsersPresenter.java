package com.wingshield.technologies.demopostdata.presentation.presenters;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.domain.executor.Executor;
import com.wingshield.technologies.demopostdata.domain.executor.MainThread;
import com.wingshield.technologies.demopostdata.domain.interactors.DeleteUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.InsertUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.LoadUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.UpdateUserDataInteractor;
import com.wingshield.technologies.demopostdata.domain.interactors.impl.DeleteUsersDataInteractorimpl;
import com.wingshield.technologies.demopostdata.domain.interactors.impl.GetUsersDataInteractorimpl;
import com.wingshield.technologies.demopostdata.domain.interactors.impl.InsertUsersDataInteractorimpl;
import com.wingshield.technologies.demopostdata.domain.interactors.impl.UpdateUsersDataInteractorimpl;
import com.wingshield.technologies.demopostdata.model.Users;
import com.wingshield.technologies.demopostdata.presentation.ui.activities.UserView;

import java.util.List;

public class UsersPresenter extends AbstractPresenter implements LoadUserDataInteractor.Callback, UpdateUserDataInteractor.Callback, InsertUserDataInteractor.Callback, DeleteUserDataInteractor.Callback {

    private final UserView userView;
    private JsonObject jsonObject;
    private int id;

    public UsersPresenter(Executor executor, MainThread mainThread, UserView userView, JsonObject jsonObject, int id) {
        super(executor, mainThread);
        this.userView = userView;
        this.jsonObject = jsonObject;
        this.id = id;
    }

    public UsersPresenter(Executor executor, MainThread mainThread, UserView userView) {
        super(executor, mainThread);
        this.userView = userView;
    }

    public void getAllUsers(){
       new GetUsersDataInteractorimpl(mExecutor,mMainThread,this).execute();
    }

    public void updateUser(){
        new UpdateUsersDataInteractorimpl(mExecutor,mMainThread,this,jsonObject,id).execute();
    }

    public void deleteUser(){
        new DeleteUsersDataInteractorimpl(mExecutor,mMainThread,this,jsonObject,id).execute();

    }

    public void insertUser(){
        new InsertUsersDataInteractorimpl(mExecutor,mMainThread,this,jsonObject).execute();
    }

    @Override
    public void getUsers(List<Users> usersList) {
        if (usersList!=null){
            userView.getUsers(usersList);
        }
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void UpdateStatus(int code) {

        userView.updateUser(code);
    }

    @Override
    public void DataInsert(int status) {
        userView.insertUser(status);
    }

    @Override
    public void UserDelete(int code) {
            userView.deleteUser(code);
    }
}
