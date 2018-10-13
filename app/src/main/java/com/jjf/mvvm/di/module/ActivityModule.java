package com.jjf.mvvm.di.module;

import android.support.v4.app.FragmentActivity;
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
    private final FragmentActivity mActivity;

    public ActivityModule(FragmentActivity activity) {
        this.mActivity = activity;
    }

    @ActivityScope
    @Provides
    public FragmentActivity provideActivity(){
        return mActivity;
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(FragmentActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
