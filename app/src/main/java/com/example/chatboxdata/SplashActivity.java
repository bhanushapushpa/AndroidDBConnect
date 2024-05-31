package com.example.chatboxdata;

import static java.lang.Thread.*;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread() {


        public void run() {
            try {
                sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivities(new Intent[]{intent});
            }
        }

        };
        thread.start();



    }
}