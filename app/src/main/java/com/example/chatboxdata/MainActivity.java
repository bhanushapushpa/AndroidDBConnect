package com.example.chatboxdata;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add,subtract;
    EditText etFirstNumber,etSecondNumber;
    TextView tvResult;



  //  @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        tvResult= findViewById(R.id.tvResult);
        add = findViewById(R.id.btAdd);
        subtract = findViewById(R.id.btSubtract);


        add.setOnClickListener(view -> {
            int first,second,ans;
            first=Integer.parseInt(etFirstNumber.getText().toString());
            second =Integer.parseInt(etSecondNumber.getText().toString());

            ans= first+second;
            tvResult.setText("Addition of Two number is "+ans);
        });

        subtract.setOnClickListener(view -> {
            int first,second,result;

            first = Integer.parseInt(etFirstNumber.getText().toString());
            second = Integer.parseInt(etSecondNumber.getText().toString());
            result = first - second;

            tvResult.setText("After Subtract number is "+result);
        });
   }
}