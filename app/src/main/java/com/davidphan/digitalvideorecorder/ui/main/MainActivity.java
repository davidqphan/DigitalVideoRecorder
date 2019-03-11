package com.davidphan.digitalvideorecorder.ui.main;

import android.os.Bundle;

import com.davidphan.digitalvideorecorder.R;
import com.davidphan.digitalvideorecorder.data.model.Program;
import com.davidphan.digitalvideorecorder.data.model.Question;
import com.davidphan.digitalvideorecorder.data.remote.ProgramService;
import com.davidphan.digitalvideorecorder.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    @Inject
    String sillyString;

    @Inject
    ProgramService programService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.d("Here is your injected silly string: %s", sillyString);

        Call<List<Question>> questions = programService.listQuestions();

        questions.enqueue(new Callback<List<Question>>() {

            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                List<Question> q = response.body();
                if (q != null) {
                    for (int i = 0; i < q.size(); i++) {
                        Question question = q.get(i);
                        Timber.d("question: %s", question);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                Timber.e(t, t.getLocalizedMessage());

            }
        });

    }

}
