package com.davidphan.digitalvideorecorder.injection.module;

import com.davidphan.digitalvideorecorder.ui.main.MainActivity;
import com.davidphan.digitalvideorecorder.ui.main.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?> bindMainActivity(MainActivityComponent.Builder builder);

}
