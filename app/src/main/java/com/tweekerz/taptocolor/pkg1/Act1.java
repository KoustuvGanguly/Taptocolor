package com.tweekerz.taptocolor.pkg1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.tweekerz.taptocolor.R;

import java.util.Random;

/**
 * Created by Koustuv Ganguly on 09-Jun-17.
 */

public class Act1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.lyt1);
            findViewById(R.id.ll1).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        Random random=new Random();
                        int color= Color.argb(random.nextInt(150),random.nextInt(255),random.nextInt(255),random.nextInt(255));
                        view.setBackgroundColor(color);
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
