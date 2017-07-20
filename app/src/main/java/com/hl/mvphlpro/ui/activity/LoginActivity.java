package com.hl.mvphlpro.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hl.mvphlpro.R;
import com.hl.mvphlpro.presenter.impl.LoginPresenter;
import com.hl.mvphlpro.view.LoginView;
import com.orhanobut.logger.Logger;
import com.qm.maplib.MapActivity;


import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends BaseActivity implements LoginView {
    private static final String TAG = "LoginActivity";
    private LoginPresenter mLoginPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /**
         * loading初始化
         */
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("请稍后。。。");
        Logger.d("11111111111111111111111");

    }

    @Override
    protected void onResume() {
        super.onResume();
        mLoginPresenter = new LoginPresenter(this, this);
        mLoginPresenter.Login("admin", "admin");
    }

    @Override
    public void showLoading() {

        if (progressDialog != null) {
            progressDialog.show();
        }

    }

    @Override
    public void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showMsg(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                //执行一些其他操作
                //.............
                //执行完毕，触发回调，通知观察者
                e.onNext("我来发射数据");
            }
        });

        Observer<String> observer = new Observer<String>() {


            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            //观察者接收到通知,进行相关操作
            public void onNext(String aLong) {
                Log.e(TAG, "onNext: " + aLong);
                Logger.d(aLong);
                System.out.println("我接收到数据了");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
//        Intent i = new Intent(this, MapActivity.class);
//        startActivity(i);
    }
}
