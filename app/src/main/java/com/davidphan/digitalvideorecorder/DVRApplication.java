package com.davidphan.digitalvideorecorder;

import android.app.Activity;
import android.app.Application;

import com.davidphan.digitalvideorecorder.injection.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class DVRApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setupTimber();
        setupDagger();
    }

    private void setupDagger() {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    private void setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());

        }
    }

}
