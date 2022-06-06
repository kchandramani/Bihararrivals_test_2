package com.example.bihararrivals_test_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bihararrivals_test_2.databinding.ActivitySendOtpBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;
//import app.my.otpverification.databinding.ActivityOtpSendBinding;

public class send_otp extends AppCompatActivity {

    private ActivitySendOtpBinding binding;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etPhone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(send_otp.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                } else if (binding.etPhone.getText().toString().trim().length() != 10) {
                    Toast.makeText(send_otp.this, "Type valid Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    otpsend();
                }
            }
        });
    }

    private void otpsend() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.btnsend.setVisibility(View.INVISIBLE);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                binding.progressBar.setVisibility(View.GONE);
                binding.btnsend.setVisibility(View.VISIBLE);
                Toast.makeText(send_otp.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                binding.progressBar.setVisibility(View.GONE);
                binding.btnsend.setVisibility(View.VISIBLE);
                Toast.makeText(send_otp.this, "OTP is successfully send.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(send_otp.this, sms_verification.class);
                intent.putExtra("phone", binding.etPhone.getText().toString().trim());
                intent.putExtra("verificationId", verificationId);
                startActivity(intent);
            }
        };

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + binding.etPhone.getText().toString().trim())
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallbacks)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}