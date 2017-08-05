package com.tweekerz.taptocolor.pkg1;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.tweekerz.taptocolor.R;

import java.util.Random;

/**
 * Created by Koustuv Ganguly on 09-Jun-17.
 */

public class Act1 extends AppCompatActivity {

    private ToneGenerator toneGen1;
    private int multyConst = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.lyt1);
            final LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.ll1);
            linearLayout1.setBackgroundResource(R.drawable.placeholder);
            linearLayout1.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (toneGen1 != null) {
                            toneGen1.stopTone();
                            toneGen1.release();
                        }
                        Random random = new Random();
                        int color = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
                        view.setBackgroundColor(color);
                        toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
                        Random random1 = new Random();
                        int soundConstant = random1.nextInt(9);
                        toneGen1.startTone(soundConstant, multyConst);
                        linearLayout1.setClickable(false);
                        final Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                        if (vibrator.hasVibrator()) {
                            vibrator.vibrate(multyConst);
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    linearLayout1.setClickable(true);
                                    vibrator.cancel();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, multyConst);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (toneGen1 != null) {
            toneGen1.stopTone();
            toneGen1.release();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
