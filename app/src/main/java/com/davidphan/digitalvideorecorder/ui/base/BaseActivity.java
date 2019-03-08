package com.davidphan.digitalvideorecorder.ui.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;

/**
 * Base class to enforce every Activity to follow Dagger's Dependency Injection setup.
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
    
}
