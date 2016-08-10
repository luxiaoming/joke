package com.xm.joke.adapter;


import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuguangqiang.support.widgets.recyclerview.adapter.AbsRVAdapter;
import com.xm.joke.databinding.ItemJokeTextBinding;
import com.xm.joke.model.bean.JokeTextBean.ShowapiResBodyBean.ContentlistBean;

import java.util.List;

public class TextJokeAdapter extends AbsRVAdapter<ContentlistBean,TextJokeAdapter.textViewHolder> {


    public TextJokeAdapter(Context context, List<ContentlistBean> data) {
        super(context, data);
    }

    @Override
    public textViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return textViewHolder.createViewHolder(ItemJokeTextBinding.inflate(layoutInflater));
    }

    @Override
    public void onBindViewHolder(textViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
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

    }

}
