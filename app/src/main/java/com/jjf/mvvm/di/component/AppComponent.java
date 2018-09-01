package com.jjf.mvvm.di.component;

import android.content.Context;

import com.jjf.mvvm.data.DataManager;
import com.jjf.mvvm.data.db.IDbHelper;
import com.jjf.mvvm.data.http.IHttpHelper;
import com.jjf.mvvm.data.prefs.IPreferencesHelper;
import com.jjf.mvvm.di.ApplicationContext;
import com.jjf.mvvm.di.module.AppModule;
import com.jjf.mvvm.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author :jinjiafeng
 * date:  on 18-8-29
 * description:
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    @ApplicationContext
    Context getContext();

    DataManager getDataManager(); //数据中心

    IHttpHelper retrofitHelper();  //提供http的帮助类

    IDbHelper dbHelper();    //提供数据库帮助类

    IPreferencesHelper preferencesHelper(); //提供sp帮助类
}
