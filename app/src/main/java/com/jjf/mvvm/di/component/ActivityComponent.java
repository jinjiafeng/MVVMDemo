package com.jjf.mvvm.di.component;

import com.jjf.mvvm.di.module.ViewModel;
import com.jjf.mvvm.ui.main.MainActivity;
import com.jjf.mvvm.di.ActivityScope;
import com.jjf.mvvm.di.module.ActivityModule;

import dagger.Component;

/**
 * @author :jinjiafeng
 * date:  on 18-8-29
 * description:
 */
@ActivityScope
@Component(dependencies ={ AppComponent.class}, modules = {ActivityModule.class, ViewModel.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
}
