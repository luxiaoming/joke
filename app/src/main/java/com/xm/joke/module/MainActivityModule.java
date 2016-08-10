package com.xm.joke.module;


import android.content.Context;

import com.xm.joke.ViewModel.MainViewModel;
import com.xm.joke.model.MainModel;
import com.xm.joke.model.MeiziModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private Context context;
    public MainActivityModule(Context context) {
        this.context = context;
    }
    @Provides
    MainViewModel provideViewModel(Context context) {
        return new MainViewModel(context, new MainModel(),new MeiziModel());
    }
    @Provides
    Context provideContext() {
        return context;
    }
}
