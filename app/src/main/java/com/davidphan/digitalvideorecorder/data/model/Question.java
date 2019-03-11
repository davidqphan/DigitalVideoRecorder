package com.davidphan.digitalvideorecorder.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Question {

    @SerializedName("question")
    public abstract String question();

    @SerializedName("published_at")
    public abstract String publishedAt();

    @SerializedName("choices")
    public abstract List<Choice> choices();
    
    public static TypeAdapter<Question> typeAdapter(Gson gson) {
        return new AutoValue_Question.GsonTypeAdapter(gson);
    }

}
