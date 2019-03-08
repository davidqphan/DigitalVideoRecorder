package com.davidphan.digitalvideorecorder.ui.main;

import dagger.Module;
import dagger.Provides;

/**
 * This module provides Main Activity related instances (eg. MainViewModel, Retrofit, etc..)
 */
@Module
public class MainActivityModule {

    @Provides
    String provideSillyString() {
        return "Silly";
    }
    
}
