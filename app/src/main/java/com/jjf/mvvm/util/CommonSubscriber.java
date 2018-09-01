package com.jjf.mvvm.util;

import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;

import com.jjf.mvvm.data.http.ApiException;
import com.jjf.mvvm.data.http.Resource;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * Created by codeest on 2017/2/23.
 */

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private MutableLiveData<Resource> mStateLiveData;

    protected CommonSubscriber(MutableLiveData<Resource> liveData) {
        this.mStateLiveData = liveData;
    }

    @Override
    public void onComplete() {

    }


    @Override
    public void onError(Throwable e) {
        final Resource value = mStateLiveData.getValue();
        if (mStateLiveData == null || value == null) {
            return;
        }
        if (!TextUtils.isEmpty(value.message)) {
            mStateLiveData.setValue(Resource.error(value.message));
        } else if (e instanceof ApiException) {
            mStateLiveData.setValue(Resource.error(e.getMessage()));
        } else if (e instanceof HttpException) {
            mStateLiveData.setValue(Resource.error("数据加载失败ヽ(≧Д≦)ノ"));
        } else {
            mStateLiveData.setValue(Resource.error("未知错误ヽ(≧Д≦)ノ"));
        }

        //        if (value.isShowError) {
        //            mStateLiveData.stateError();
        //        }
    }
}
