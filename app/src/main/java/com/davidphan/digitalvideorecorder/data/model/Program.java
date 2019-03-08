package com.davidphan.digitalvideorecorder.data.model;

import com.google.auto.value.AutoValue;

import java.sql.Timestamp;
import java.time.Duration;

@AutoValue
public abstract class Program {
    static Program create(String id,
                          String title,
                          Timestamp startTime,
                          Duration duration,
                          String posterImageUrl) {
        return new AutoValue_Program(id, title, startTime, duration, posterImageUrl);
    }

    abstract String id();

    abstract String title();

    abstract Timestamp startTime();

    abstract Duration duration();

    abstract String posterImageUrl();
}
