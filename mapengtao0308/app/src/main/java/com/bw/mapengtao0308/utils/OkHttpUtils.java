package com.bw.mapengtao0308.utils;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Time:2019.03.08--13:50
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class OkHttpUtils {

    //    私有的静态的
    private static OkHttpUtils okHttpUtils = null;

    private OkHttpUtils() {

    }

    public static OkHttpUtils getInstance() {

//        同步
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }

        return okHttpUtils;
    }

    public Interceptor getInterceptor(){

//        拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("mmm",message);
            }
        });

        return interceptor;
    }

//    get方法
    public void  doGet(String url, Callback callback){

//        OkHttpClient
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(getInterceptor())
                .build();

//        Request
        Request request = new Request
                .Builder()
                .url(url)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
