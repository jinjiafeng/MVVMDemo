package com.jjf.mvvm.di.module;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import com.jjf.mvvm.ui.main.MainViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author jjf
 * Created by jinjiafeng
 * Time :2018/9/1
 */

@Module
public class ViewModelInjectModel {

    @Provides
    public MainViewModel provideViewModel(FragmentActivity activity){
        return ViewModelProviders.of(activity).get(MainViewModel.class);
    }
}
