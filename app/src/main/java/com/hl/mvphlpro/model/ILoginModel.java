package com.hl.mvphlpro.model;

/**
 * Created by XueYang on 2017/7/7.
 */

public interface ILoginModel {
    interface LoginListener {
        void OnSuccess(String s);

        void OnError(String s);

        void OnIllFormat();
    }

    void Login(String username, String pwd, LoginListener listener);
}
