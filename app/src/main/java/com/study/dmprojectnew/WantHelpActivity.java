package com.study.dmprojectnew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WantHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_help);

        Button btnHelpOkay = findViewById(R.id.btnHelpOkay);
        btnHelpOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHome = new Intent(WantHelpActivity.this, MainActivity.class);
                startActivity(goHome);
                finish();
            }
        });
    }
}