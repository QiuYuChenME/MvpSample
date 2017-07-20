package com.hl.mvphlpro.view;

import android.view.animation.Animation;

/**
 * Created by XueYang on 2017/7/7.
 */

public interface ISplashView {
    /**
     * 起始页 内容展示
     *
     * @param versionName
     * @param copyright
     * @param backgroundResId
     */
    void initViews(String versionName, String copyright, int backgroundResId);

    /**
     * 起始页自动跳转主页
     */
    void navigateToHomePage();

    /**
     * 添加动画
     * @param animation
     */
    void animateBackgroundImage(Animation animation);
}
