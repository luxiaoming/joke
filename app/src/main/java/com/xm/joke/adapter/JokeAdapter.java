package com.xm.joke.adapter;


import android.annotation.IntDef;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuguangqiang.support.widgets.recyclerview.adapter.AbsRVAdapter;
import com.xm.joke.databinding.ItemJokePicBinding;
import com.xm.joke.databinding.ItemJokeTextBinding;
import com.xm.joke.model.bean.BaseBean;
import com.xm.joke.model.bean.JokePicBean;
import com.xm.joke.model.bean.JokeTextBean;
import com.xm.joke.model.bean.JokeTextBean.ShowapiResBodyBean.ContentlistBean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class JokeAdapter extends AbsRVAdapter<BaseBean, JokeAdapter.textViewHolder> {
    public static final int TEXT_MODE = 1;
    public static final int PIC_MODE = 2;

    @IntDef({
            TEXT_MODE,
            PIC_MODE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface JokeMode {
    }

    public JokeAdapter(Context context, List<BaseBean> data) {
        super(context, data);
    }

    @Override
    public textViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TEXT_MODE) {
            return textViewHolder.createViewHolder(ItemJokeTextBinding.inflate(layoutInflater,parent,false));
        } else {
            return textViewHolder.createViewHolder(ItemJokePicBinding.inflate(layoutInflater,parent,false));

        }
    }

    @Override
    public void onBindViewHolder(textViewHolder holder, int position) {
        BaseBean bean = data.get(position);
        if (bean instanceof ContentlistBean) {
            holder.bindData((ContentlistBean) data.get(position));
        } else {
            holder.bindData((JokePicBean.ShowapiResBodyBean.ContentlistBean) data.get(position));
        }
    }


    @Override
    public int getItemViewType(int position) {
        BaseBean bean = data.get(position);
        if (bean instanceof ContentlistBean) {
            return TEXT_MODE;
        } else {
            return PIC_MODE;
        }
    }

    public static class textViewHolder extends RecyclerView.ViewHolder {

        public static textViewHolder createViewHolder(ViewDataBinding binding) {
            return new textViewHolder(binding.getRoot(), binding);
        }

        public textViewHolder(View view, ViewDataBinding binding) {
            super(view);
            itemView.setTag(binding);
        }

        public void bindData(ContentlistBean textJoke) {
            ItemJokeTextBinding binding = (ItemJokeTextBinding) itemView.getTag();
            binding.setItem(textJoke);
            binding.executePendingBindings();
        }

        public void bindData(JokePicBean.ShowapiResBodyBean.ContentlistBean picJoke) {
            ItemJokePicBinding binding = (ItemJokePicBinding) itemView.getTag();
            binding.setItem(picJoke);
            binding.executePendingBindings();
        }
    }

}
