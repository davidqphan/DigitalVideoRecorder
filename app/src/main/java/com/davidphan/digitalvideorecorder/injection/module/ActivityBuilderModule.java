package com.davidphan.digitalvideorecorder.injection.module;

import com.davidphan.digitalvideorecorder.ui.main.MainActivity;
import com.davidphan.digitalvideorecorder.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity contributesMainActivity();

}
