package com.davidphan.digitalvideorecorder.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Choice {

    @SerializedName("choice")
    public abstract String choice();

    @SerializedName("votes")
    public abstract int votes();

    public static TypeAdapter<Choice> typeAdapter(Gson gson) {
        return new AutoValue_Choice.GsonTypeAdapter(gson);
    }

}
