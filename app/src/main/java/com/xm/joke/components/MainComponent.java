/*
 * Copyright 2016 code_gg_boy, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xm.joke.components;

import com.xm.core.components.BaseActivityComponent;
import com.xm.core.components.BaseAppComponent;
import com.xm.core.injector.ForActivity;
import com.xm.core.module.BaseAppModule;
import com.xm.joke.activity.MainActivity;
import com.xm.joke.module.MainActivityModule;

import javax.inject.Singleton;

import dagger.Component;

@ForActivity
@Component(modules = MainActivityModule.class)
public interface MainComponent extends BaseActivityComponent{
     void inject(MainActivity mainActivity);
}