package com.study.dmprojectnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CredentialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials);
    }
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}