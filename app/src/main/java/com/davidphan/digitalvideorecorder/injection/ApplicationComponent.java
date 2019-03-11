package com.davidphan.digitalvideorecorder.injection;

import android.app.Application;

import com.davidphan.digitalvideorecorder.DVRApplication;
import com.davidphan.digitalvideorecorder.data.remote.ProgramService;
import com.davidphan.digitalvideorecorder.injection.module.ActivityBuilderModule;
import com.davidphan.digitalvideorecorder.injection.module.AppModule;
import com.davidphan.digitalvideorecorder.injection.module.RemoteModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Component is a graph which will provide injected instances by using modules.
 * This is responsible for providing application scope instances.
 */

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilderModule.class,
})
public interface ApplicationComponent {

    /**
     * Binds some instance to our component, in this case, we want to inject our DvrApplication
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(DVRApplication dvrApplication);
}
