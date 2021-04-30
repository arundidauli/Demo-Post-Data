package com.wingshield.technologies.demopostdata.presentation.ui.activities.impl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.wingshield.technologies.demopostdata.R;
import com.wingshield.technologies.demopostdata.model.Post;
import com.wingshield.technologies.demopostdata.presentation.ui.adapters.CategoriesAdapter;
import com.wingshield.technologies.demopostdata.presentation.ui.adapters.ProfileRowAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProfileActivity extends AppCompatActivity {

    @BindView(R.id.rv_settings)
    RecyclerView rv_settings;
    List<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);
        postList=new ArrayList<>();
        rv_settings.setLayoutManager(new LinearLayoutManager(this));
        rv_settings.setAdapter(new ProfileRowAdapter(this,postList));


    }
}