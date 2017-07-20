package com.hl.mvphlpro.model;

import android.content.Context;
import android.view.animation.Animation;

/**
 * Created by XueYang on 2017/7/7.
 */

public interface ISplashModel {

    int getBackgroundImageResID();

    String getCopyright(Context context);

    String getVersionName(Context context);

    Animation getBackgroundImageAnimation(Context context);
}
