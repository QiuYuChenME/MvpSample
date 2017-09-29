package com.hl.mvphlpro.retrofitURL;

import com.hl.mvphlpro.bean.BookSearchResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by XueYang on 2017/5/2.
 */

public interface TestURLService {

    @GET("book/search")
    Call<BookSearchResponse> getSearchBooks(@Query("q") String name,
                                            @Query("tag") String tag,
                                            @Query("start") int start,
                                            @Query("count") int count);

    /**
     * 山西 登录接口
     *
     * @param name 用户名
     * @param pwd  密码
     * @return
     */
    @GET("SXproject/Android/login.action")
    Call<ResponseBody> Login_sx(@Query("userName") String name,
                                @Query("passWord") String pwd);


}
