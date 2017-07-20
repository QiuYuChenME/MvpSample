package com.hl.mvphlpro.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.hl.mvphlpro.R;
import com.hl.mvphlpro.presenter.impl.SplashPresenter;
import com.hl.mvphlpro.view.ISplashView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements ISplashView {

    private static final String TAG = "SplashActivity";
    @BindView(R.id.splash_image)
    ImageView splashImage;
    @BindView(R.id.splash_version_name)
    TextView splashVersionName;
    @BindView(R.id.splash_copyright)
    TextView splashCopyright;
    private SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
//        /**
//         * 隐藏actionbar
//         */
//        getSupportActionBar().hide();
//        /**
//         * 状态栏透明
//         */
//        if (Build.VERSION.SDK_INT >= 19)
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


    }

    @Override
    protected void onResume() {
        super.onResume();

        /**
         * presenter
         */
        mSplashPresenter = new SplashPresenter(this, this);
        mSplashPresenter.initialized();
    }

    @Override
    public void initViews(String versionName, String copyright, int backgroundResId) {
        splashImage.setBackgroundResource(backgroundResId);
        splashVersionName.setText(versionName);
        splashCopyright.setText(copyright);
    }

    @Override
    public void navigateToHomePage() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void animateBackgroundImage(Animation animation) {
        splashImage.startAnimation(animation);
    }
}
