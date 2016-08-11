package com.xm.joke.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.xm.joke.BR;
import com.xm.joke.view.DBRecyclerView;


import java.util.ArrayList;
import java.util.List;

public abstract class AbsRecyclerViewModel<T> extends BaseObservable {

    @Bindable
    public List<T> data = new ArrayList<>();

    @Bindable
    public int footerStatus = DBRecyclerView.SHOW_FOOTER;

    @Bindable
    public boolean loading = false;


    public void setData(List<T> data) {
        this.data = data;
    }


    public List<T> getData() {
        return data;
    }

    public int getFooterStatus() {
        return footerStatus;
    }

    public void setFooterStatus(int footerStatus) {
        this.footerStatus = footerStatus;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public boolean isLoading() {
        return loading;
    }

    public void requestData() {
        loading = true;
        notifyPropertyChanged(BR.loading);
    }

    public void onRequestFinished() {
        loading = false;
        notifyPropertyChanged(BR.loading);
    }

    public void onRequestSuccess(List<T> list) {
        if (list.size() < 20) {
            footerStatus = DBRecyclerView.HIDE_FOOTER;
        } else {
            footerStatus = DBRecyclerView.SHOW_FOOTER;
        }

        data.addAll(list);
        notifyPropertyChanged(BR.data);
    }

}
