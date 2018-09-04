package com.jjf.mvvm.di.module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.jjf.mvvm.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public FragmentActivity provideActivity() {
        return fragment.getActivity();
    }
}
