package com.chensi.animation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private Button btnScale;
    private Button btnAlpha;
    private Button btnRotate;
    private Button btnTranslate;
    private Button btnContinue;
    private Button btnContinue2;
    private Button btnFlash;
    private Button btnMove;
    private Button btnChange;
    private Button btnLayout;
    private Button btnFrame;
    private ImageView ivImage;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        addListener(getApplicationContext());
    }

    private void initViews() {
        btnScale = (Button) findViewById(R.id.btnScale);
        btnAlpha = (Button) findViewById(R.id.btnAlpha);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnTranslate = (Button) findViewById(R.id.btnTranslate);
        btnContinue = (Button) findViewById(R.id.btnContinue);
        btnContinue2 = (Button) findViewById(R.id.btnContinue2);
        btnFlash = (Button) findViewById(R.id.btnFlash);
        btnMove = (Button) findViewById(R.id.btnMove);
        btnChange = (Button) findViewById(R.id.btnChange);
        btnLayout = (Button) findViewById(R.id.btnLayout);
        btnFrame = (Button) findViewById(R.id.btnFrame);
        ivImage = (ImageView) findViewById(R.id.ivImage);
    }

    private void addListener(final Context context) {
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale);
                ivImage.startAnimation(animation);
            }
        });
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.alpha);
                ivImage.startAnimation(animation);
            }
        });
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate);
                ivImage.startAnimation(animation);
            }
        });
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.translate);
                ivImage.startAnimation(animation);
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate);
                final Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.translate);
                ivImage.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ivImage.startAnimation(animation2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        btnContinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.continue_anim);
                ivImage.startAnimation(animation);
            }
        });
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation animation = new TranslateAnimation(-50, 50, 0, 0);
                animation.setDuration(1000);
                animation.setRepeatCount(Animation.INFINITE);
                animation.setRepeatMode(Animation.REVERSE);
                ivImage.startAnimation(animation);
            }
        });
        btnFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(50);
                alphaAnimation.setRepeatCount(20);
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                ivImage.startAnimation(alphaAnimation);
            }
        });
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
            }
        });
        btnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivImage.setImageResource(R.drawable.animation_list);
            }
        });
    }
}
