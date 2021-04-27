package com.wingshield.technologies.demopostdata.presentation.ui.activities.impl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.wingshield.technologies.demopostdata.R;
import com.wingshield.technologies.demopostdata.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginRegisterActivity extends AppCompatActivity {

    @BindView(R.id.et_number)
    EditText number;
    @BindView(R.id.btn_next)
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        ButterKnife.bind(this);


        findViewById(R.id.btn_next).setOnClickListener(v -> {
            if (TextUtils.isEmpty(number.getText().toString())){
                number.setError("Valid Contact Number");
                number.requestFocus();
            }else {
                Intent intent = new Intent(getApplicationContext(), OtpVerifyActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra(Constants.NUMBER,number.getText().toString());
                startActivity(intent);
            }




        });

    }
}