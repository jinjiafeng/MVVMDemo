package com.jjf.mvvm.base;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jjf.mvvm.App;
import com.jjf.mvvm.data.DataManager;
import com.jjf.mvvm.data.http.Resource;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by jinjiafeng
 * Time :2018/9/1
 */
public class BaseViewModel extends ViewModel {

    /**
     * 记录view状态 loading error finish
     */
    private LiveData<Resource> mStateLiveData = new MutableLiveData<>();
    private final DataManager mDataManager;
    private final CompositeDisposable mCompositeDisposable;

    public BaseViewModel() {
        this.mDataManager = App.getInstance().getAppComponent().getDataManager();
        this.mCompositeDisposable = new CompositeDisposable();
    }


    protected void addSubscribe(Disposable subscription) {
        mCompositeDisposable.add(subscription);
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public LiveData<Resource> getState() {
        return mStateLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.clear();
    }
}
