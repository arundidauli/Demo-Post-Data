package com.wingshield.technologies.demopostdata.presentation.ui.activities.impl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.wingshield.technologies.demopostdata.R;

public class OtpVerifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        });

    }
}