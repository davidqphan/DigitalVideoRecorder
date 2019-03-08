package com.davidphan.digitalvideorecorder.ui.main;

import android.os.Bundle;

import com.davidphan.digitalvideorecorder.R;
import com.davidphan.digitalvideorecorder.ui.base.BaseActivity;

import javax.inject.Inject;

import timber.log.Timber;

public class MainActivity extends BaseActivity {

    @Inject
    String sillyString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.d("Here is your injected silly string: %s", sillyString);
    }

}
