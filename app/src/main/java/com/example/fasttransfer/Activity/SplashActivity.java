package com.example.fasttransfer.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fasttransfer.Constants;
import com.example.fasttransfer.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_activity_splash);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat insetsController =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());

        insetsController.hide(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars());
        insetsController.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);

        ImageView splashLogo = findViewById(R.id.splash_logo);
        FrameLayout logoContainer = findViewById(R.id.logo_container);

        logoContainer.post(() -> {
            splashLogo.setVisibility(View.VISIBLE);
            Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            splashLogo.startAnimation(fadeInAnimation);
        });

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, SenderDetailsActivity.class);
            startActivity(intent);
            finish();
        }, Constants.SPLASH_SCREEN_DURATION);
    }
}
