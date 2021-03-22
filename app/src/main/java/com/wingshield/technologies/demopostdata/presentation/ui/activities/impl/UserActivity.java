package com.wingshield.technologies.demopostdata.presentation.ui.activities.impl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.wingshield.technologies.demopostdata.R;
import com.wingshield.technologies.demopostdata.domain.executor.impl.ThreadExecutor;
import com.wingshield.technologies.demopostdata.model.Users;
import com.wingshield.technologies.demopostdata.presentation.presenters.PostDataPresenter;
import com.wingshield.technologies.demopostdata.presentation.presenters.UsersPresenter;
import com.wingshield.technologies.demopostdata.presentation.ui.activities.UserView;
import com.wingshield.technologies.demopostdata.presentation.ui.adapters.PostAdapter;
import com.wingshield.technologies.demopostdata.presentation.ui.adapters.UserAdapter;
import com.wingshield.technologies.demopostdata.presentation.ui.uiInterface.UserListener;
import com.wingshield.technologies.demopostdata.threading.MainThreadImpl;

import org.w3c.dom.Text;

import java.util.List;

public class UserActivity extends AppCompatActivity implements UserView, UserListener {
    private static final String TAG=UserActivity.class.getSimpleName();
    private TextView empty_view;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        progressBar=findViewById(R.id.progress_circular);
        empty_view=findViewById(R.id.txt_no_record_found);

        startActivity(new Intent(getApplicationContext(),AppointmentActivity.class));
        fetchData();
    }

    private void fetchData(){
        progressBar.setVisibility(View.VISIBLE);
        new UsersPresenter(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(),this).getAllUsers();


    }

    @Override
    public void getUsers(List<Users> usersList) {
        RecyclerView rv_post=findViewById(R.id.rv_user);
        progressBar.setVisibility(View.GONE);
        if (usersList.size()>0){
            rv_post.setLayoutManager(new LinearLayoutManager(UserActivity.this));
            rv_post.setAdapter(new UserAdapter(UserActivity.this, usersList,this));
        }else {
            empty_view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void updateUser(int message) {
        Toast.makeText(UserActivity.this,"Delete"+message,Toast.LENGTH_LONG).show();
        fetchData();
    }

    @Override
    public void deleteUser(int message) {

        Toast.makeText(UserActivity.this,"Delete"+message,Toast.LENGTH_LONG).show();

        fetchData();

    }

    @Override
    public void insertUser(int message) {

    }

    @Override
    public void delete(String id) {
        new UsersPresenter(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(),this,null,Integer.parseInt(id)).deleteUser();

    }

    @Override
    public void Update(Users users) {
        Log.e(TAG,"ID: "+users.getId());
        Log.e(TAG,"Name: "+users.getName());
        Log.e(TAG,"Email ID: "+users.getEmail());
        Log.e(TAG,"gender: "+users.getGender());
        Log.e(TAG,"Status: "+users.getStatus());

        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("name",users.getName());
        jsonObject.addProperty("email",users.getEmail());
        jsonObject.addProperty("status",users.getStatus());

        new UsersPresenter(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(),this,jsonObject,Integer.parseInt(users.getId())).updateUser();

    }
}