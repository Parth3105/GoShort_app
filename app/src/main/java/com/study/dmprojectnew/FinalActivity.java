package com.study.dmprojectnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    int i = 0;
    int j = 0;
    TextView dialogTxt1;
    TextView dialogTxt2;
    Button btnClose;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_final);

        Dialog congratsDialog = new Dialog(this);
        congratsDialog.setContentView(R.layout.final_congrats_layout);
        congratsDialog.setCancelable(false);
        btnClose = congratsDialog.findViewById(R.id.btnClose);
        btnHome = congratsDialog.findViewById(R.id.btnHome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                congratsDialog.setCanceledOnTouchOutside(false);
                congratsDialog.show();
            }
        }, 800);

        dialogTxt1 = congratsDialog.findViewById(R.id.dialogTxt1);
        dialogTxt2 = congratsDialog.findViewById(R.id.dialogTxt2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initialize(getResources().getString(R.string.dialogTxt1));
                    }
                }, 400);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                initialize1(getResources().getString(R.string.dialogTxt2));
                            }
                        }, 400);
                    }
                }, 1500);
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnClose.setVisibility(View.VISIBLE);
                btnHome.setVisibility(View.VISIBLE);
            }
        }, 5900);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHome = new Intent(FinalActivity.this, MainActivity.class);
                startActivity(goHome);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });


    }

    public void onBackPressed() {

    }

    public void initialize(String passedText) {
        if (i < passedText.length()) {
            String fetchText = passedText.substring(0, i);
            dialogTxt1.setText(fetchText);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    i++;
                    initialize(passedText);
                }
            }, 50);
        }
    }

    public void initialize1(String passedText) {
        if (j < passedText.length()) {
            String fetchText = passedText.substring(0, j);
            dialogTxt2.setText(fetchText);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    j++;
                    initialize1(passedText);
                }
            }, 50);
        }
    }
}