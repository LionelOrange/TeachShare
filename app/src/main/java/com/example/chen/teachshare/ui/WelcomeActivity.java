package com.example.chen.teachshare.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chen.teachshare.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Administrator on 2016/5/26.
 */
public class WelcomeActivity extends Activity {//第一个活动
    @InjectView(R.id.welecome_image)
    ImageView welcomeImg;

    @InjectView(R.id.count_down)
    TextView countDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        Picasso.with(this).load(R.drawable.welcome_img1).into(welcomeImg);//封面广告图片加载
        final Typeface font = Typeface.createFromAsset(getAssets(), "splash.ttf");
        countDown.setTypeface(font);
        // 倒数计时
        CountDownTimer timer = new CountDownTimer(3200, 1000) {
            int num = 2;

            @Override
            public void onTick(long millisUntilFinished) {
                countDown.setText(String.valueOf(num));
                num--;
            }

            @Override
            public void onFinish() {
                Intent i = new Intent(WelcomeActivity.this, com.example.chen.teachshare.ui.MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                overridePendingTransition(0, 0);
                finish();
            }
        };
        timer.start();
    }


}
