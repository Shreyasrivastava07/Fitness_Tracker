package com.example.fitnesstracker;

import static java.lang.Integer.valueOf;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {

    String buttonValue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MtimeRunning;
    private long MtimeLeftinmills;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        buttonValue = intent.getStringExtra("value");
        int intValue = 0;
        intValue = Integer.parseInt(buttonValue);

        switch (intValue) {

            case 1:
                setContentView(R.layout.activity_bow);
                break;
            case 2:
                setContentView(R.layout.activity_bow2);
                break;
            case 3:
                setContentView(R.layout.activity_bow3);
                break;
            case 4:
                setContentView(R.layout.activity_bow4);
                break;
            case 5:
                setContentView(R.layout.activity_bow5);
                break;
            case 6:
                setContentView(R.layout.activity_bow6);
                break;
            case 7:
                setContentView(R.layout.activity_bow7);
                break;
            case 8:
                setContentView(R.layout.activity_bow8);
                break;
            case 9:
                setContentView(R.layout.activity_bow9);
                break;
            case 10:
                setContentView(R.layout.activity_bow10);
                break;
            case 11:
                setContentView(R.layout.activity_bow11);
                break;
            case 12:
                setContentView(R.layout.activity_bow12);
                break;
            case 13:
                setContentView(R.layout.activity_bow13);
                break;
            case 14:
                setContentView(R.layout.activity_bow14);
                break;
            case 15:
                setContentView(R.layout.activity_bow15);
                break;


        }

        startBtn = findViewById(R.id.startButton);
        mtextview = findViewById(R.id.time);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MtimeRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }

            private void startTimer() {
                final CharSequence value1 = mtextview.getText();
                String num1 = value1.toString();
                String num2 = num1.substring(0, 2);
                String num3 = num1.substring(3, 5);



                    final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
                    MtimeLeftinmills = number * 1000;

                    countDownTimer = new CountDownTimer(MtimeLeftinmills, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            MtimeLeftinmills = millisUntilFinished;
                            updateTimer();
                        }

                        @Override
                        public void onFinish() {
                            int newvalue = Integer.valueOf(buttonValue) + 1;
                            if (newvalue <= 7) {
                                Intent intent1 = new Intent(ThirdActivity.this, ThirdActivity.class);
                                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent1.putExtra("value", String.valueOf(newvalue));
                                startActivity(intent1);
                            } else {
                                newvalue = 1;
                                Intent intent = new Intent(ThirdActivity.this, ThirdActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.putExtra("value", String.valueOf(newvalue));
                                startActivity(intent);
                            }
                        }
                    }.start();
                    startBtn.setText("PAUSE");
                    MtimeRunning = true;
                }

            private void updateTimer() {
                int minutes = (int) MtimeLeftinmills / 60000;
                int seconds = (int) MtimeLeftinmills % 60000 / 1000;

                String timeLeftText = "";
                if (minutes < 10) {
                    timeLeftText = "0";
                }
                timeLeftText = timeLeftText + minutes + ":";
                if (seconds < 10)
                    timeLeftText += "0";
                timeLeftText += seconds;
                mtextview.setText(timeLeftText);


            }

            private void stopTimer() {
                countDownTimer.cancel();
                MtimeRunning = false;
                startBtn.setText("START");


            }

            public void onBackPressed() {

                ThirdActivity.super.onBackPressed();
            }

        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}