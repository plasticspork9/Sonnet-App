package com.example.sonnet.Splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sonnet.MainActivity;
import com.example.sonnet.R;

public class SplashWelcome extends AppCompatActivity {
    ImageView splashImage;
    private static int SPLASH_SCREEN_TIMER = 5750;
    private Intent toLoginScreenIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_welcome);

        splashImage = findViewById(R.id.splash_image);

        Glide.with(SplashWelcome.this)
                .load(R.drawable.splash_screen_image)
                .into(splashImage);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                toLoginScreenIntent = new Intent(SplashWelcome.this, MainActivity.class);
                startActivity(toLoginScreenIntent);
                finish();
            }
        }, SPLASH_SCREEN_TIMER);
    }
}
