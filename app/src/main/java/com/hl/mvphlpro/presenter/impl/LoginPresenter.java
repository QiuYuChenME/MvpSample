package com.hl.mvphlpro.presenter.impl;

import android.content.Context;
import android.util.Log;

import com.hl.mvphlpro.model.ILoginModel;
import com.hl.mvphlpro.model.impl.LoginModelImpl;
import com.hl.mvphlpro.view.LoginView;

/**
 * Created by XueYang on 2017/7/7.
 */

public class LoginPresenter implements LoginModelImpl.LoginListener {

    private static final String TAG = "LoginPresenter";
    private LoginView mLoginView = null;
    private ILoginModel mLoginModelImpl = null;
    private Context mContext;

    public LoginPresenter(Context mContext, LoginView mLoginView) {
        this.mContext = mContext;
        this.mLoginView = mLoginView;
        mLoginModelImpl = new LoginModelImpl();
    }

    public void Login(String username, String pwd) {
        mLoginView.showLoading();
        mLoginModelImpl.Login(username, pwd, this);
    }

    @Override
    public void OnSuccess(String s) {
        mLoginView.hideLoading();
        mLoginView.navigateToHome();

        Log.e(TAG, "OnSuccess: " + s);
        mLoginView.showMsg(s);
    }

    @Override
    public void OnError(String s) {
        mLoginView.hideLoading();
        mLoginView.showMsg(s);
    }

    @Override
    public void OnIllFormat() {
        mLoginView.hideLoading();
        mLoginView.showMsg("账号、密码格式不正确");
    }
}
