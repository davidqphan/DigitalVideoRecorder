package com.davidphan.digitalvideorecorder.data.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RecordingFailure {
    static RecordingFailure create(){
        return new AutoValue_RecordingFailure("Exceeded limit of recordings");
    }

    abstract String errorMessage();
}
