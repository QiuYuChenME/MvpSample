package com.hl.mvphlpro.presenter.impl;

import android.content.Context;
import android.view.animation.Animation;

import com.hl.mvphlpro.model.impl.SplashModelImpl;
import com.hl.mvphlpro.presenter.Presenter;
import com.hl.mvphlpro.view.ISplashView;

/**
 * Created by XueYang on 2017/7/7.
 */

public class SplashPresenter implements Presenter {

    private ISplashView mISplashView = null;
    private SplashModelImpl mSplashModelImpl = null;
    private Context mContext = null;

    public SplashPresenter(Context mContext, ISplashView mISplashView) {
        if (null == mISplashView) {
            throw new IllegalArgumentException("Constructor's parameters must not be Null");
        }
        this.mContext = mContext;
        this.mISplashView = mISplashView;
        mSplashModelImpl = new SplashModelImpl();
    }

    @Override
    public void initialized() {
        mISplashView.initViews(mSplashModelImpl.getVersionName(mContext),
                mSplashModelImpl.getCopyright(mContext),
                mSplashModelImpl.getBackgroundImageResID());
        Animation backgroundImageAnimation = mSplashModelImpl.getBackgroundImageAnimation(mContext);
        /**
         * 监听动画加载
         */
        backgroundImageAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mISplashView.navigateToHomePage();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        /**
         *背景图添加动画
         */
        mISplashView.animateBackgroundImage(backgroundImageAnimation);
    }
}
