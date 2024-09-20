package com.minhtruong.random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText txtNumber;
    EditText txtNumber2;
    TextView numberResult;
    Button btnrandom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtNumber = (EditText) findViewById(R.id.textViewNumber);
        txtNumber2 =(EditText) findViewById(R.id.textViewNumber2);
        btnrandom = (Button) findViewById(R.id.button2Click);
        numberResult = (TextView) findViewById(R.id.textView4);


        btnrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String number1Str = txtNumber.getText().toString();
                    String number2Str = txtNumber2.getText().toString();
                    if (number1Str.isEmpty() || number2Str.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int number1 = Integer.parseInt(number1Str);
                    int number2 = Integer.parseInt(number2Str);
                    if (number2 <= number1) {
                        Toast.makeText(MainActivity.this, "Number 2 must be greater than Number 1", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Random random = new Random();
                    int numberRandom = random.nextInt(number2 - number1 + 1) + number1;
                    numberResult.setText(String.valueOf(numberRandom));

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}