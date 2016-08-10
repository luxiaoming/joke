package com.xm.joke.app;

import com.xm.core.app.BaseApp;
import com.xm.core.components.BaseAppComponent;
import com.xm.core.module.BaseAppModule;
import com.xm.joke.components.DaggerAppComponent;


public class App extends BaseApp {

    @Override
    protected BaseAppComponent initAppComponent() {
        return DaggerAppComponent.builder().baseAppModule(new BaseAppModule(this)).build();
    }

    @Override
    protected boolean initCanaryOpen() {
        return true;
    }
}
