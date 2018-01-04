package universe.com.universe.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import universe.com.universe.android.R;


/**
 * Created by gaurav.pandey on 02-01-2018.
 */

public class SplashActivity extends AppCompatActivity{

    private Runnable mRunnable;
    private Handler mHandler = new Handler();
    private static int SPLASH_TIME_OUT = 1000;
    Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext=this;
        mRunnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mContext, MainActivity.class));
            }
        };
        mHandler.postDelayed(mRunnable, SPLASH_TIME_OUT);
    }




    @Override
    public void onBackPressed() {
        mHandler.removeCallbacks(mRunnable);
        super.onBackPressed();
    }
}
