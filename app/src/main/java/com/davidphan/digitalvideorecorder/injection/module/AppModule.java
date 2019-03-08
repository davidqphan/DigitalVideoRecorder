package com.davidphan.digitalvideorecorder.injection.module;

import android.app.Application;
import android.content.Context;

import com.davidphan.digitalvideorecorder.ui.main.MainActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {
        MainActivityComponent.class
})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

}
