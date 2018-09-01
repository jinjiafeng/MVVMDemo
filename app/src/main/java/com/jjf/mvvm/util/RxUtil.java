package com.jjf.mvvm.util;

import com.jjf.mvvm.data.http.ApiException;
import com.jjf.mvvm.data.http.BaseModel;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author :jinjiafeng
 * date:  on 18-8-30
 * description:
 */
public class RxUtil {
    /**
     * 统一线程处理
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }



    /**
     * 统一返回结果处理
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<BaseModel<T>, T> handleResult() {
        return httpResponseObservable ->
                httpResponseObservable.flatMap((Function<BaseModel<T>, Observable<T>>) baseResponse -> {
                    if(baseResponse.getCode() == BaseModel.SUCCESS && baseResponse.getResults() != null) {
                        return createData(baseResponse.getResults());
                    } else {
                        return Observable.error(new ApiException(baseResponse.getMessage()));
                    }
                });
    }

    /**
     * 得到 Observable
     * @param <T> 指定的泛型类型
     * @return Observable
     */
    private static <T> Observable<T> createData(final T t) {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }
}
