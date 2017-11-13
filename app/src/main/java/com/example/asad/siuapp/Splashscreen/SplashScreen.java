package com.example.asad.siuapp.Splashscreen;

import android.content.Intent;
import android.content.pm.ActivityInfo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.asad.siuapp.Home.MainActivity;
import com.example.shobojit.siuapp.R;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splash_screen);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.up_to_down);
        ImageView spLogo = (ImageView) findViewById(R.id.splash_screen_logo);
        spLogo.setAnimation(anim);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();
            }
        },2000);
    }
}
