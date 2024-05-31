package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText name,password;
    TextView error;
    Button submit;
    Api api;
    String Base_url= "http://10.0.2.2:8080/Connect/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.button1);
        error = findViewById(R.id.error);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }

            private void insertData() {
                String name1 = name.getText().toString();
                String password1 = password.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                api = retrofit.create(Api.class);

                loginUser myData = new loginUser();
                myData.setName(name1);
                myData.setPassword(password1);

                Call<Void> loginUserCall = api.insertUser(myData);

                loginUserCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e("MainActivity", "Error: " + response.code() + " - " + response.message());
                            if (response.errorBody() != null) {
                                try {
                                    String errorResponse = response.errorBody().string();
                                    Log.e("MainActivity", "Error body: " + errorResponse);
                                    Toast.makeText(MainActivity.this, "Error: " + errorResponse, Toast.LENGTH_SHORT).show();
                                    error.setText(errorResponse);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        System.out.println(t.getMessage());
                        error.setText(t.getMessage());
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }
}