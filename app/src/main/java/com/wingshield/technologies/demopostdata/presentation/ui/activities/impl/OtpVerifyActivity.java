package com.wingshield.technologies.demopostdata.presentation.ui.activities.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.wingshield.technologies.demopostdata.R;
import com.wingshield.technologies.demopostdata.utils.Constants;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpVerifyActivity extends AppCompatActivity {
    private static final String TAG = OtpVerifyActivity.class.getSimpleName();
    @BindView(R.id.resend_code)
    TextView resend_otp;
    @BindView(R.id.et_otp)
    EditText et_otp;
    @BindView(R.id.progress_circular)
    ProgressBar progressBar;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    private String verificationCode, verificationNumber;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);
        context = OtpVerifyActivity.this;
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();

        Intent i = getIntent();
        if (i.getStringExtra(Constants.NUMBER) != null) {
            StartFirebaseLogin();
            verificationNumber = i.getStringExtra(Constants.NUMBER);
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    "+91" + i.getStringExtra(Constants.NUMBER),// Phone number to verify
                    60,                           // Timeout duration
                    TimeUnit.SECONDS,                // Unit of timeout
                    OtpVerifyActivity.this, // Activity (for callback binding)
                    mCallback);
            //OnVerificationStateChangedCallbacks
            countDown();
        }

        findViewById(R.id.btn_next).setOnClickListener(v -> {

            if (TextUtils.isEmpty(et_otp.getText().toString())) {
                et_otp.setError("Enter OTP");
                et_otp.requestFocus();
            } else {
                String get_otp = et_otp.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, get_otp);
                SignInWithPhone(credential);
            }
        });

    }

    private void StartFirebaseLogin() {
        progressBar.setVisibility(View.VISIBLE);
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                progressBar.setVisibility(View.GONE);
                if (phoneAuthCredential.getSmsCode() != null) {
                    et_otp.setText(phoneAuthCredential.getSmsCode());
                }
                mAuth.signInWithCredential(phoneAuthCredential)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                firebaseUser = task.getResult().getUser();
                                Toast.makeText(OtpVerifyActivity.this, "Verify", Toast.LENGTH_SHORT).show();
                                NextActivity();
                            } else {
                                Toast.makeText(OtpVerifyActivity.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                            }
                        });


            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                progressBar.setVisibility(View.GONE);
                Log.w(TAG, "onVerificationFailed", e);
                Toast.makeText(OtpVerifyActivity.this, "We have blocked all requests from this phone due to unusual use. Try again later", Toast.LENGTH_SHORT).show();

                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    e.printStackTrace();
                    Toast.makeText(OtpVerifyActivity.this, "Invalid request try with another number", Toast.LENGTH_SHORT).show();
                    // Invalid request
                    // ...
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    Toast.makeText(OtpVerifyActivity.this, "You have login enough time,Try again later after 24 hours.", Toast.LENGTH_SHORT).show();

                    e.printStackTrace();

                }

            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                progressBar.setVisibility(View.GONE);
                mResendToken = forceResendingToken;
                verificationCode = s;
                et_otp.setText(s);
                Toast.makeText(OtpVerifyActivity.this, "Code has sent", Toast.LENGTH_SHORT).show();
            }
        };
    }


    private void SignInWithPhone(PhoneAuthCredential credential) {
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        progressBar.setVisibility(View.GONE);
                        firebaseUser = task.getResult().getUser();
                        Toast.makeText(OtpVerifyActivity.this, "Verify", Toast.LENGTH_SHORT).show();

                        NextActivity();
                    } else {
                        Toast.makeText(OtpVerifyActivity.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                    }
                });

    }

    private void countDown() {
        if (resend_otp != null) {
            resend_otp.setClickable(false);
            resend_otp.setEnabled(false);
            new CountDownTimer(60000, 1000) {

                public void onTick(long millisUntilFinished) {
                    String second_timer = millisUntilFinished / 1000 + " Seconds remaining";
                    resend_otp.setText(second_timer);
                    resend_otp.setClickable(false);
                    resend_otp.setEnabled(false);
                    //here you can have your logic to set text to edit text
                }

                public void onFinish() {
                    resend_otp.setText(context.getString(R.string.txt_resend_otp));
                    resend_otp.setClickable(true);
                    resend_otp.setEnabled(true);


                    resend_otp.setOnClickListener(v -> {
                        if (progressBar != null) {
                            progressBar.setVisibility(View.VISIBLE);
                        }
                        countDown();
                        resendVerificationCode("+91" + verificationNumber, mResendToken);
                    });
                }

            }.start();
        }

    }

    private void resendVerificationCode(String phoneNumber, PhoneAuthProvider.ForceResendingToken token) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallback,         // OnVerificationStateChangedCallbacks
                token);             // ForceResendingToken from callbacks
    }

    private void NextActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}