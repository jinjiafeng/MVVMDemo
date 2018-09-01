package com.jjf.mvvm.di.module;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;

import com.jjf.mvvm.ui.main.MainViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author jjf
 * Created by jinjiafeng
 * Time :2018/9/1
 */

@Module
public class ViewModel {

    @Provides
    public MainViewModel provideViewModel(AppCompatActivity activity){
        return ViewModelProviders.of(activity).get(MainViewModel.class);
    }
}
