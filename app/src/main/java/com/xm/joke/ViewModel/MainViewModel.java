package com.xm.joke.ViewModel;


import android.annotation.IntDef;
import android.content.Context;
import android.databinding.Bindable;
import android.view.Gravity;
import android.view.View;

import com.liuguangqiang.support.widgets.recyclerview.OnPageListener;
import com.xm.joke.R;
import com.xm.joke.adapter.JokeAdapter;
import com.xm.joke.model.AbsRecyclerViewModel;
import com.xm.joke.model.MainModel;
import com.xm.joke.model.MeiziModel;
import com.xm.joke.model.bean.BaseBean;
import com.xm.joke.model.bean.JokeTextBean;
import com.xm.joke.view.MainView;
import com.xm.joke.view.RequestView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import javax.inject.Inject;

import com.xm.joke.BR;
import com.xm.joke.view.SetImageUrl;

public class MainViewModel extends AbsRecyclerViewModel<BaseBean> implements SetImageUrl, MainView, RequestView<BaseBean> {


    private JokeAdapter adapter;
    private MainModel mainModel;
    private Context context;
    private MeiziModel meiziModel;

    int textpage = 1;
    int picpage = 1;
    public static final int TEXT_MODE = 1;
    public static final int PIC_MODE = 2;

    @IntDef({
            TEXT_MODE,
            PIC_MODE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface JokeMode {
    }

    @Bindable
    boolean closeDraw;

    public boolean isCloseDraw() {
        return closeDraw;
    }

    public void setCloseDraw(boolean closeDraw) {
        this.closeDraw = closeDraw;
    }

    @JokeMode
    int cur_mode = TEXT_MODE;

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
    public MainViewModel(Context context, MainModel mainModel, MeiziModel meiziModel) {
        this.context = context;
        this.mainModel = mainModel;
        this.meiziModel = meiziModel;
        mainModel.setView(this);
        meiziModel.setView(this);
        adapter = new JokeAdapter(context, getData());
        requestData();
    }

    @Override
    public void onRequestSuccess(List<BaseBean> list) {
        super.onRequestSuccess(list);
        if (cur_mode == TEXT_MODE) {
            textpage++;
        } else {
            picpage++;
        }
    }

    public JokeAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void requestData() {
        super.requestData();
        if (cur_mode == TEXT_MODE) {
            mainModel.getTextJoke(textpage);
            meiziModel.getmeizi(textpage);
        } else {
            mainModel.getPicJoke(picpage);
            meiziModel.getmeizi(picpage);
        }
    }

    public void onclick(View view) {

        switch (view.getId()) {
            case R.id.text_mode:
                if (cur_mode == TEXT_MODE) return;
                setJokeMode(TEXT_MODE);
                break;
            case R.id.pic_mode:
                if (cur_mode == PIC_MODE) return;
                setJokeMode(PIC_MODE);
                break;

        }
    }

    public void setJokeMode(@JokeMode int mode) {
        cur_mode = mode;
        requestData();
        notifyPropertyChanged(BR.closeDraw);
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
