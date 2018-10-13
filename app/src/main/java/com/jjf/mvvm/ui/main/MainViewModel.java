package com.jjf.mvvm.ui.main;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;

import com.jjf.mvvm.base.BaseViewModel;
import com.jjf.mvvm.util.ToastUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @author :jinjiafeng
 * Created by jinjiafeng
 * Time :2018/9/1
 */
public class MainViewModel extends BaseViewModel implements LifecycleObserver{

    public MutableLiveData<Long> mMsgLiveData = new MutableLiveData<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(LifecycleOwner lifecycleOwner){
        ToastUtils.showLong(lifecycleOwner.toString());

    }

    public void sendMessage() {
        //todo 测试
        addSubscribe(Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mMsgLiveData.postValue(aLong);
                    }
                }));
    }
}
