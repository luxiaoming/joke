package com.xm.joke.net;

import com.xm.joke.model.bean.JokePicBean;
import com.xm.joke.model.bean.JokeTextBean;


import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface Joke {

    @Headers("apikey:23f66c1dd2976a23208f583d32549043")
    @GET("joke_text")
    Observable<JokeTextBean> getjoketext(@Query("page") int page);

    @Headers("apikey:23f66c1dd2976a23208f583d32549043")
    @GET("joke_pic")
    Observable<JokePicBean> getjokepic(@Query("page") int page);
}
