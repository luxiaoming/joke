package com.xm.joke.activity;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.xm.core.activity.BaseActivity;
import com.xm.joke.R;
import com.xm.joke.ViewModel.MainViewModel;
import com.xm.joke.components.AppComponent;
import com.xm.joke.components.DaggerMainComponent;
import com.xm.joke.databinding.ActivityMainBinding;
import com.xm.joke.module.MainActivityModule;
import com.xm.joke.net.Joke;

import javax.inject.Inject;

import qiu.niorgai.StatusBarCompat;

public class MainActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainComponent.builder().mainActivityModule(new MainActivityModule(this)).build().inject(this);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setViewModel(mMainViewModel);
        StatusBarCompat.translucentStatusBar(this);
        initToolbar();
    }

    ActivityMainBinding mainBinding;
    @Inject
    MainViewModel mMainViewModel;

    private void initToolbar() {
        setSupportActionBar(mainBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_menu);
        collapsingToolbar = mainBinding.collapsingToolbar;
        collapsingToolbar.setTitle(getString(R.string.app_name));
        collapsingToolbar.setExpandedTitleColor(Color.WHITE);
        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:

                mainBinding.drawerLayout.openDrawer(Gravity.LEFT);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
