package com.davidphan.digitalvideorecorder.data.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Recording {
    static Recording create(String recordingId) {
        return new AutoValue_Recording(recordingId);
    }

    abstract String recordingId();
}
