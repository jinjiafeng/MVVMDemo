package com.jjf.mvvm.di.module;

import android.app.Application;
import android.content.Context;

import com.jjf.mvvm.data.DataManager;
import com.jjf.mvvm.data.db.AppDbHelper;
import com.jjf.mvvm.data.db.IDbHelper;
import com.jjf.mvvm.data.http.IHttpHelper;
import com.jjf.mvvm.data.http.RetrofitHelper;
import com.jjf.mvvm.data.prefs.AppPreferencesHelper;
import com.jjf.mvvm.data.prefs.IPreferencesHelper;
import com.jjf.mvvm.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author :jinjiafeng
 * date:  on 18-8-29
 * description:
 */
@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @ApplicationContext
    @Provides
    public Context getContext() {
        return mApplication;
    }

    @Singleton
    @Provides
    public IHttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Singleton
    @Provides
    public IPreferencesHelper providePreferencesHelper(AppPreferencesHelper preferencesHelper) {
        return preferencesHelper;
    }

    @Singleton
    @Provides
    public IDbHelper provideDbHelper(AppDbHelper dbHelper) {
        return dbHelper;
    }

    @Singleton
    @Provides
    public DataManager provideDataManager(IHttpHelper httpHelper,IPreferencesHelper preferencesHelper,
                                        IDbHelper dbHelper ) {
        return new DataManager(httpHelper,preferencesHelper,dbHelper);
    }
}
