package com.xm.joke.model;

/**
 * Created by Administrator on 2016/8/10.
 */

import com.xm.joke.model.bean.JokeTextBean;
import com.xm.joke.model.bean.MeiziBean;
import com.xm.joke.net.Joke;
import com.xm.joke.net.Meizi;
import com.xm.joke.net.RetrofitClient;
import com.xm.joke.view.RequestView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import com.xm.joke.model.bean.JokeTextBean;
import com.xm.joke.net.Joke;
import com.xm.joke.net.RetrofitClient;
import com.xm.joke.view.MainView;
import com.xm.joke.view.RequestView;
import com.xm.joke.view.SetImageUrl;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MeiziModel {

    private Meizi meizi;

    private SetImageUrl setImageUrl;

    public MeiziModel() {
        meizi = RetrofitClient.builder(RetrofitClient.meizi).build(Meizi.class);
    }

    public void setView(SetImageUrl setImageUrl) {
        this.setImageUrl = setImageUrl;

    }

    public void getmeizi(int page) {
        meizi.getMeizi(page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<MeiziBean>() {
            @Override
            public void onCompleted() {
                int a=0;
                a=3;
            }

            @Override
            public void onError(Throwable e) {
                int a=0;
                a=3;
            }

            @Override
            public void onNext(MeiziBean meiziBean) {
                setImageUrl.setImageUrl(meiziBean.getResults().get(0).getUrl());
            }
        });

    }

}
