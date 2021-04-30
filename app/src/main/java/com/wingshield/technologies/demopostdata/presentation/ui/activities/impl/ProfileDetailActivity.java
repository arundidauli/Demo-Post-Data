package com.wingshield.technologies.demopostdata.presentation.ui.activities.impl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.wingshield.technologies.demopostdata.R;
import com.wingshield.technologies.demopostdata.model.Post;
import com.wingshield.technologies.demopostdata.presentation.ui.adapters.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileDetailActivity extends AppCompatActivity {

    @BindView(R.id.rv_gallery)
    RecyclerView rv_gallery;
    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);
        ButterKnife.bind(this);
        posts=new ArrayList<>();

        rv_gallery.setLayoutManager(new LinearLayoutManager(ProfileDetailActivity.this,RecyclerView.HORIZONTAL,false));
        rv_gallery.setAdapter(new GalleryAdapter(ProfileDetailActivity.this,posts));

    }
}