package com.xm.joke.ViewModel;


import android.content.Context;
import android.databinding.Bindable;

import com.liuguangqiang.support.widgets.recyclerview.OnPageListener;
import com.xm.joke.model.AbsRecyclerViewModel;
import com.xm.joke.adapter.TextJokeAdapter;
import com.xm.joke.model.MainModel;
import com.xm.joke.model.MeiziModel;
import com.xm.joke.model.bean.JokeTextBean;
import com.xm.joke.view.MainView;
import com.xm.joke.view.RequestView;

import java.util.List;

import javax.inject.Inject;
import com.xm.joke.BR;
import com.xm.joke.view.SetImageUrl;

public class MainViewModel extends AbsRecyclerViewModel<JokeTextBean.ShowapiResBodyBean.ContentlistBean> implements SetImageUrl, MainView, RequestView<JokeTextBean.ShowapiResBodyBean.ContentlistBean> {


    private TextJokeAdapter adapter;
    private MainModel mainModel;
    private Context context;
    private MeiziModel meiziModel;
    int page=1;

    @Bindable
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @Inject
    public MainViewModel(Context context, MainModel mainModel,MeiziModel meiziModel) {
        this.context = context;
        this.mainModel = mainModel;
        this.meiziModel=meiziModel;
        mainModel.setView(this);
        meiziModel.setView(this);
        adapter = new TextJokeAdapter(context, getData());
        requestData();
    }

    @Override
    public void onRequestSuccess(List<JokeTextBean.ShowapiResBodyBean.ContentlistBean> list) {
        super.onRequestSuccess(list);
        page++;
    }

    public TextJokeAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void requestData() {
      super.requestData();
      mainModel.getTextJoke(page);

        meiziModel.getmeizi(page);
    }

    public OnPageListener getOnPageListener() {
        return new OnPageListener() {
            @Override
            public void onPage() {
                requestData();
            }
        };
    }

}
