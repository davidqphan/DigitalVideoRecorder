package com.davidphan.digitalvideorecorder.ui.base;

import android.content.Context;

import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

/**
 * Base class to enforce every Fragment to follow Dagger's Dependency Injection setup.
 * Note: Not every activity will need a Fragment.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

}
