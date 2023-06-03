package com.study.dmprojectnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OneTimeActivity extends AppCompatActivity {

    Button btnRead;

    String prevStarted = "yes";

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            btnRead = findViewById(R.id.btnRead);
            btnRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(prevStarted, Boolean.TRUE);
                    editor.apply();
                    moveToSecondary();
                }
            });
        } else {
            moveToSecondary();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time);

        //get Instructions first time app run
    }

    public void moveToSecondary() {
        // use an intent to travel from one activity to another.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onBackPressed() {
    }
}