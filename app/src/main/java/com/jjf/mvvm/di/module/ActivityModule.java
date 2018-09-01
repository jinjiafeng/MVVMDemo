package com.jjf.mvvm.di.module;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.jjf.mvvm.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author :jinjiafeng
 * date:  on 18-8-29
 * description:
 */
@Module
public class ActivityModule {
    private final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @ActivityScope
    @Provides
    public AppCompatActivity provideActivity(){
        return mActivity;
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
