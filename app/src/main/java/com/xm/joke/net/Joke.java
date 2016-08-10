package com.xm.joke.net;

import com.xm.joke.model.bean.JokeTextBean;


import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;
import rx.Observable;

public interface Joke {

    @Headers("apikey:23f66c1dd2976a23208f583d32549043")
    @GET("joke_text")
    Observable<JokeTextBean> getjoketext(@Query("urlParam") int urlParam);

    @Headers("apikey:23f66c1dd2976a23208f583d32549043")
    @GET("joke_pic")
    Observable<JokeTextBean> getjokepic(@Query("urlParam") int urlParam);
}
