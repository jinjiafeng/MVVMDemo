package com.jjf.mvvm.ui.main;

import android.arch.lifecycle.MutableLiveData;

import com.jjf.mvvm.base.BaseViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**@author :jinjiafeng
 * Created by jinjiafeng
 * Time :2018/9/1
 */
public class MainViewModel extends BaseViewModel {

    public MutableLiveData<Long> mMsgLiveData = new MutableLiveData<>();

    public void sendMessage() {
        //todo 测试
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mMsgLiveData.postValue(aLong);
                    }
                });
    }
}
