package com.jjf.mvvm.di.component;

import com.jjf.mvvm.di.ActivityScope;
import com.jjf.mvvm.di.module.ActivityModule;
import com.jjf.mvvm.di.module.ViewModelInjectModel;
import com.jjf.mvvm.ui.main.MainActivity;

import dagger.Component;

/**
 * @author :jinjiafeng
 * date:  on 18-8-29
 * description:
 */
@ActivityScope
@Component(dependencies ={ AppComponent.class}, modules = {ActivityModule.class, ViewModelInjectModel.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
}
