package com.hl.mvphlpro.model.impl;

import android.util.Log;
import com.hl.mvphlpro.common.Constants;
import com.hl.mvphlpro.model.ILoginModel;
import com.hl.mvphlpro.retrofitURL.TestURLService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by XueYang on 2017/7/7.
 */

public class LoginModelImpl implements ILoginModel {
    private static final String TAG = "LoginModelImpl";

    @Override
    public void Login(String username, String pwd, final LoginListener listener) {


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.douban.com/v2/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        TestURLService service = retrofit.create(TestURLService.class);
//        Call<BookSearchResponse> call = service.getSearchBooks("小王子", "", 0, 3);
//        call.enqueue(new Callback<BookSearchResponse>() {
//            @Override
//            public void onResponse(Call<BookSearchResponse> call, Response<BookSearchResponse> response) {
//                BookSearchResponse body = response.body();
//                Log.e(TAG, "onResponse: " + body);
//                listener.OnSuccess();
//            }
//
//            @Override
//            public void onFailure(Call<BookSearchResponse> call, Throwable t) {
//                Log.e(TAG, "onResponse: " + t.getMessage());
//                listener.OnError();
//            }
//        });
        if (username == null || "".equals(username) || pwd == null || "".equals(pwd)) {
            listener.OnIllFormat();
            return;
        }


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASEURL_SX)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TestURLService testURLService = retrofit.create(TestURLService.class);
        Call<ResponseBody> call = testURLService.Login_sx("admin", "admin");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    String string = response.body().string();
                    Log.e(TAG, "onResponse: " + string);
                    listener.OnSuccess(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String s = t.toString();
                listener.OnError(s);
                Log.e(TAG, "onResponse: " + s);
            }
        });
    }
}
