package com.minhtruong.signinsignup;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.Toast;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText usernameSignIn, passwordSignIn;
    Button signInBtn, createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        usernameSignIn = findViewById(R.id.usernameSignIn);
        passwordSignIn = findViewById(R.id.passwordSignIn);
        signInBtn = findViewById(R.id.signInBtn);
        createAccountBtn = findViewById(R.id.createAccountBtn);
        signInBtn.setOnClickListener(view -> {
            String username = usernameSignIn.getText().toString();
            String password = passwordSignIn.getText().toString();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Sign In Successful!", Toast.LENGTH_SHORT).show();
            }
        });
        createAccountBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}