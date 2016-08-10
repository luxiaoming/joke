package com.xm.joke.net;

import com.xm.joke.model.bean.MeiziBean;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;


public interface Meizi {

    @GET("1/{page}")
    Observable<MeiziBean> getMeizi(@Path("page") int page);

}
