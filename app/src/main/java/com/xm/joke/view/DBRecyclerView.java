package com.xm.joke.view;

import android.databinding.BindingAdapter;
import android.text.Html;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuguangqiang.support.widgets.recyclerview.SuperRecyclerView;
import com.liuguangqiang.support.widgets.recyclerview.adapter.AbsRVAdapter;
import com.xm.joke.R;
import com.xm.joke.model.bean.JokeTextBean;

import java.util.List;

public class DBRecyclerView {

    public static int SHOW_FOOTER = 0;

    public static int HIDE_FOOTER = 1;

    @BindingAdapter({"adapter"})
    public static void bindAdapter(SuperRecyclerView recyclerView, AbsRVAdapter adapter) {
        recyclerView.setAdapter(adapter);
        recyclerView.setPageFooter(R.layout.layout_loading_footer);
    }

    @BindingAdapter({"data"})
    public static void bindData(SuperRecyclerView recyclerView, List<JokeTextBean.ShowapiResBodyBean.ContentlistBean> data) {
        recyclerView.notifyDataSetChanged();
        recyclerView.setIsLoading(false);
    }

    @BindingAdapter({"isLoading"})
    public static void isLoading(SuperRecyclerView recyclerView, boolean isLoading) {
        recyclerView.setIsLoading(isLoading);
    }

    @BindingAdapter({"footerStatus"})
    public static void footerStatus(SuperRecyclerView recyclerView, int footerStatus) {
        if (footerStatus == SHOW_FOOTER) {
            recyclerView.setPageEnable(true);
            recyclerView.showLoadingFooter();
        } else {
            recyclerView.setPageEnable(false);
            recyclerView.removePageFooter();
        }
    }

    @BindingAdapter({"htmltext"})
    public static void htmltext(TextView textView, String text) {
        if (!text.isEmpty()) {
            textView.setText(Html.fromHtml(text));
        }
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView iv, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl))
            Glide.with(iv.getContext()).load(imageUrl).into(iv);
    }
}
