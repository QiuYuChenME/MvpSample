package com.hl.mvphlpro.model.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.hl.mvphlpro.R;
import com.hl.mvphlpro.model.ISplashModel;

/**
 * Created by XueYang on 2017/7/7.
 */

public class SplashModelImpl implements ISplashModel {
    @Override
    public int getBackgroundImageResID() {

        return R.mipmap.afternoon;
    }

    @Override
    public String getCopyright(Context context) {
        return context.getResources().getString(R.string.splash_copyright);
    }

    @Override
    public String getVersionName(Context context) {
        String versionName = null;
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return String.format(context.getResources().getString(R.string.splash_version), versionName);
    }

    @Override
    public Animation getBackgroundImageAnimation(Context context) {

        return AnimationUtils.loadAnimation(context,R.anim.splash);
    }
}
