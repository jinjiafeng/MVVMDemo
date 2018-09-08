package com.jjf.mvvm.di.component;

import android.support.v4.app.FragmentActivity;

import com.jjf.mvvm.di.FragmentScope;
import com.jjf.mvvm.di.module.FragmentModule;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    FragmentActivity getActivity();

}
