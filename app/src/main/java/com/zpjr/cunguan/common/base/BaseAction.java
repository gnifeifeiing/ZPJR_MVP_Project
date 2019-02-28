package com.zpjr.cunguan.common.base;

import android.util.Log;
import android.widget.Toast;

import com.zpjr.cunguan.MyApplication;
import com.zpjr.cunguan.common.cache.SharedPreferenceCache;
import com.zpjr.cunguan.common.retrofit.IApiSeivice;
import com.zpjr.cunguan.common.utils.Constants;
import com.zpjr.cunguan.common.utils.NetworkUtils;

import java.io.IOException;
import java.lang.reflect.Field;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description:      基础网络请求配置
 * Autour：          LF
 * Date：            2017/7/5 16:36
 */

public class BaseAction {

    protected Retrofit mRetrofit;
    public IApiSeivice mService;

    /**
     * 正式构造服务
     */
    public BaseAction() {
        String ip = Constants.SERVER_URL;
        mRetrofit = new Retrofit.Builder().baseUrl(ip)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService=mRetrofit.create(IApiSeivice.class);
    }

    /**
     * 某一接口更换ip时
     */
    public BaseAction(boolean bl) {
        String ip = "";
        mRetrofit = new Retrofit.Builder().baseUrl(ip)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService=mRetrofit.create(IApiSeivice.class);
    }

    /**
     * 设置是否需要传AccessToken
     */
    public void setAuthService(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
              @Override
              public Response intercept(Interceptor.Chain chain) throws IOException {
                  Request original = chain.request();

                  Request request = original.newBuilder()
                          .addHeader("Authorization", "Bearer" + " " + SharedPreferenceCache.getInstance().getPres("AccessToken"))
                          .addHeader("Content-Type","application/x-www-form-urlencoded")
                          .method(original.method(), original.body())
                          .build();

                  return chain.proceed(request);
              }
          });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        mService=retrofit.create(IApiSeivice.class);
    }
}
