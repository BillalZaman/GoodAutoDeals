package com.goodautodeal.goodautodeal.views.activities;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.helpers.UIHelper;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);

        init();
    }

    private void init() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                uiHelper.openAndClearActivity(SplashActivity.this, MainActivity.class);
            }
        }, 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null);
    }
}