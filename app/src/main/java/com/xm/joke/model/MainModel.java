package com.xm.joke.model;

import com.xm.joke.model.bean.JokeTextBean;
import com.xm.joke.net.Joke;
import com.xm.joke.net.RetrofitClient;
import com.xm.joke.view.MainView;
import com.xm.joke.view.RequestView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainModel {

    private Joke joke;
    private RequestView requestView;

    public MainModel() {
        joke = RetrofitClient.builder(RetrofitClient.joke).build(Joke.class);
    }

    public void setView(RequestView<JokeTextBean.ShowapiResBodyBean.ContentlistBean> requestView) {
        this.requestView = requestView;

    }

    public void getTextJoke(int page) {
        joke.getjoketext(page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<JokeTextBean>() {
            @Override
            public void onCompleted() {
                requestView.onRequestFinished();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(JokeTextBean jokeTextBean) {
                requestView.onRequestSuccess(jokeTextBean.getShowapi_res_body().getContentlist());
            }
        });

    }

}
