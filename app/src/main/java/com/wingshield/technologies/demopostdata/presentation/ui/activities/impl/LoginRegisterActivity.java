package com.wingshield.technologies.demopostdata.presentation.ui.activities.impl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.wingshield.technologies.demopostdata.R;

public class LoginRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),OtpVerifyActivity.class));
        });

    }
}