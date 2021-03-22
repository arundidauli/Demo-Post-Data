package com.wingshield.technologies.demopostdata.presentation.ui.activities.impl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.wingshield.technologies.demopostdata.R;

public class BookingConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirm);

        findViewById(R.id.txt_got_to_history).setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
        });
    }
}