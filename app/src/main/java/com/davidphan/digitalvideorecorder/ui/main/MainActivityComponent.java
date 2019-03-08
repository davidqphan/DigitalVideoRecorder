package com.davidphan.digitalvideorecorder.ui.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * This component is just a bridge to MainActivityModule.
 * Don't need to add inject() and build() since we have them from AndroidInjector class
 */
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
