package com.jjf.mvvm;

import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.jjf.mvvm.di.component.AppComponent;
import com.jjf.mvvm.di.component.DaggerAppComponent;
import com.jjf.mvvm.di.module.AppModule;
import com.jjf.mvvm.di.module.HttpModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author :jinjiafeng
 * date:  on 18-8-29
 * description:
 */
public class App extends Application {

    private static App sInstance;
    private AppComponent mAppComponent;
    private RefWatcher refWatcher;
    public static App getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initLogger();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refWatcher = LeakCanary.install(this);
    }

    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().
                    tag(getString(R.string.app_name)).build()));

            //把log存到本地
//            Logger.addLogAdapter(new DiskLogAdapter(TxtFormatStrategy.newBuilder().
//                    tag(getString(R.string.app_name)).build(getPackageName(), getString(R.string.app_name))));
        }
    }

    public static RefWatcher getRefWatcher(Context context){
       App app = (App) context.getApplicationContext();
        return app.refWatcher;
    }

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(sInstance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return mAppComponent;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory();
        }
        Glide.get(this).trimMemory(level);
    }

}
