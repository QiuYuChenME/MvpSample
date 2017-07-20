package com.hl.mvphlpro.view;

/**
 * Created by XueYang on 2017/7/7.
 */

public interface LoginView {

    void showLoading();

    void hideLoading();

    void showMsg(String s);

    void navigateToHome();

}
