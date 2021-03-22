package com.wingshield.technologies.demopostdata.presentation.ui.activities.impl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.auth.data.model.User;
import com.wingshield.technologies.demopostdata.R;
import com.wingshield.technologies.demopostdata.model.Users;
import com.wingshield.technologies.demopostdata.presentation.ui.adapters.HistoryAdapter;
import com.wingshield.technologies.demopostdata.presentation.ui.adapters.PostAdapter;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private List<Users> usersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        usersList=new ArrayList<>();
        RecyclerView rv_history=findViewById(R.id.rv_history);

        rv_history.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));
        rv_history.setAdapter(new HistoryAdapter(HistoryActivity.this, usersList));
    }
}