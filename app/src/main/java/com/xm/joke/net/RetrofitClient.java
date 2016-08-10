package com.xm.joke.net;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class RetrofitClient {

    public static final String joke = "http://apis.baidu.com/showapi_open_bus/showapi_joke/";
    public static final String meizi = "http://gank.io/api/data/福利/";

    private Retrofit retrofit;

    public RetrofitClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public static RetrofitClient builder(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return new RetrofitClient(retrofit);
    }


    public <T> T build(Class<?> clazz) {
        return (T) retrofit.create(clazz);
    }

}
