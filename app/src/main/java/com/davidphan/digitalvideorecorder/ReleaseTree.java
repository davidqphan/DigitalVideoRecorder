package com.davidphan.digitalvideorecorder;

import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

public class ReleaseTree extends Timber.Tree {
    @Override
    protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }

        // can setup analytics here to record exceptions when errors happen
        if (t != null) {
            if (priority == Log.ERROR) {
                // log error exceptions with Analytics
            } else if (priority == Log.WARN) {
                // log warning exceptions with analytics
            }
        }

    }
}
