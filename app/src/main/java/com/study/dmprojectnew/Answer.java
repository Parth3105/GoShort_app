package com.study.dmprojectnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Answer extends AppCompatActivity {

    AppCompatButton btnNext;
    AppCompatButton btnBack;
    RelativeLayout answerBkg;

    ArrayList<Integer> answerListBack = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_answer);

        int imgArray[][] = {
                {R.drawable.ic_launcher_background, R.drawable.image00_01, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //0
                {R.drawable.image01_00, R.drawable.ic_launcher_background, R.drawable.image01_02, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image01_14, R.drawable.ic_launcher_background, R.drawable.image01_16, R.drawable.image01_17, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //1
                {R.drawable.ic_launcher_background, R.drawable.image02_01, R.drawable.ic_launcher_background, R.drawable.image02_03, R.drawable.image02_04, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image02_13, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //2
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image03_02, R.drawable.ic_launcher_background, R.drawable.image03_04, R.drawable.ic_launcher_background, R.drawable.image03_06, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image03_13, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //3
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image04_02, R.drawable.image04_03, R.drawable.ic_launcher_background, R.drawable.image04_05, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //4
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image05_04, R.drawable.ic_launcher_background, R.drawable.image05_06, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image05_12, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image05_17, R.drawable.image05_18, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //5
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image06_03, R.drawable.ic_launcher_background, R.drawable.image06_05, R.drawable.ic_launcher_background, R.drawable.image06_07, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image06_12, R.drawable.image06_13, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //6
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image07_06, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image07_13, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image07_19, R.drawable.image07_20},    //7
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image08_14, R.drawable.image08_15, R.drawable.image08_16, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image08_19, R.drawable.ic_launcher_background},    //8
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image09_12, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image09_18, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //9
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image10_18, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //10
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image11_18, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //11
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image12_05, R.drawable.image12_06, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image12_09, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //12
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image13_02, R.drawable.image13_03, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image13_06, R.drawable.image13_07, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image13_14, R.drawable.image13_15, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image13_20},    //13
                {R.drawable.ic_launcher_background, R.drawable.image14_01, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image14_08, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image14_13, R.drawable.ic_launcher_background, R.drawable.image14_15, R.drawable.image14_16, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //14
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image15_08, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image15_13, R.drawable.image15_14, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image15_19, R.drawable.image15_20},    //15
                {R.drawable.ic_launcher_background, R.drawable.image16_01, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image16_08, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image16_14, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //16
                {R.drawable.ic_launcher_background, R.drawable.image17_01, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image17_05, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //17
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image18_05, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image18_09, R.drawable.image18_10, R.drawable.image18_11, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background},    //18
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image19_07, R.drawable.image19_08, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image19_15, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image19_20},    //19
                {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image20_07, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image20_13, R.drawable.ic_launcher_background, R.drawable.image20_15, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.image20_19, R.drawable.ic_launcher_background}    //20
        };

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        answerBkg = findViewById(R.id.answerBkg);

        Intent fromMain = getIntent();

        int imgSet1 = fromMain.getIntExtra("start", 0);
        int imgSet2 = fromMain.getIntExtra("dest", 0);
        int flag[] = new int[1];
        flag[0] = fromMain.getIntExtra("flag", -1);
        Boolean[] flag1 = {fromMain.getBooleanExtra("flag1", false)};
        Drawable img = getDrawable(imgArray[imgSet1][imgSet2]);

        ArrayList<Integer> answerList = fromMain.getIntegerArrayListExtra("answerList");
        ArrayList<Integer> answerListBack1 = fromMain.getIntegerArrayListExtra("answerList1");

        if (flag[0] == 0) {
            answerListBack.add(imgSet1);
            answerListBack.add(imgSet2);
        } else if (flag[0] == 1) {
            answerListBack1.add(imgSet2);
//            Toast.makeText(this, ""+answerListBack1.size(), Toast.LENGTH_SHORT).show();
        } else {
            flag[0] = 1;
        }

        answerBkg.setBackground(img);

        btnNext.setOnClickListener(view -> {
            flag1[0] = false;
            if (flag1[0] == false) {
                if (answerList.size() > 1) {
                    answerList.remove(0);
                }
            }

            Intent further = new Intent(Answer.this, Answer.class);

            if (answerList.size() != 1 && answerList.size() != 0) {
                int start = answerList.get(0);
                int dest = answerList.get(1);

                further.putExtra("start", start);
                further.putExtra("dest", dest);
                further.putIntegerArrayListExtra("answerList", answerList);
                if (flag[0] == 0) {
                    further.putIntegerArrayListExtra("answerList1", answerListBack);
                } else {
                    further.putIntegerArrayListExtra("answerList1", answerListBack1);
                }
                further.putExtra("flag", 1);
                further.putExtra("flag1", false);

                startActivity(further);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            } else {
                Intent finalActivity = new Intent(Answer.this, FinalActivity.class);
                startActivity(finalActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        btnBack.setOnClickListener(view -> {
            if (flag[0] != 0) {
                Intent back = new Intent(Answer.this, Answer.class);
                if (flag[0] == 1) {
                    if (answerListBack1.size() > 1) {
                        int num = answerListBack1.size() - 1;
                        answerListBack1.remove(num);
                        //Toast.makeText(this, ""+answerListBack1.get(num-1), Toast.LENGTH_SHORT).show();
                    }

                    if (answerListBack1.size() != 1 && answerListBack1.size() != 0) {

                        int number = answerListBack1.size() - 1;

                        back.putExtra("start", answerListBack1.get(number - 1));
                        back.putExtra("dest", answerListBack1.get(number));

                        ArrayList<Integer> answerListNecessary = new ArrayList<>();
                        answerListNecessary.add(answerListBack1.get(number - 1));
                        for (int j = 0; j < answerList.size(); j++) {
                            answerListNecessary.add(answerList.get(j));
                        }

                        back.putIntegerArrayListExtra("answerList", answerListNecessary);
                        back.putIntegerArrayListExtra("answerList1", answerListBack1);

                        back.putExtra("flag", 2);

                        if (answerListBack1.size() == 2) {
                            back.putExtra("flag1", false);
                        } else {
                            back.putExtra("flag1", true);
                        }
                        startActivity(back);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        finish();
                    } else {
                        Intent backHome = new Intent(Answer.this, MainActivity.class);
                        startActivity(backHome);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        finish();

                    }
                }
            } else {
                Intent backHome = new Intent(Answer.this, MainActivity.class);
                startActivity(backHome);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }

    public void onBackPressed() {
        Intent goHome = new Intent(this, MainActivity.class);
        startActivity(goHome);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}