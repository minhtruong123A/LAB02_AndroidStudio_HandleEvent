package com.minhtruong.signinsignup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText usernameSignUp, passwordSignUp, confirmPasswordSignUp;
    Button signUpBtn, signInRedirectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameSignUp = findViewById(R.id.usernameSignUp);
        passwordSignUp = findViewById(R.id.passwordSignUp);
        confirmPasswordSignUp = findViewById(R.id.confirmPasswordSignUp);
        signUpBtn = findViewById(R.id.signUpBtn);
        signInRedirectBtn = findViewById(R.id.signInRedirectBtn);
        signUpBtn.setOnClickListener(view -> {
            String username = usernameSignUp.getText().toString();
            String password = passwordSignUp.getText().toString();
            String confirmPassword = confirmPasswordSignUp.getText().toString();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(SignUpActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SignUpActivity.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        signInRedirectBtn.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}