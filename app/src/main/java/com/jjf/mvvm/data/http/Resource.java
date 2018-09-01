package com.jjf.mvvm.data.http;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by jinjiafeng
 * Time :2018/9/1
 */
public class Resource {
    @NonNull
    public final Status status;
    @Nullable
    public final String message;
    @Nullable
    public final boolean isShowError;

    private Resource(@NonNull Status status, @Nullable String message, @Nullable boolean
            isShowError) {
        this.status = status;
        this.message = message;
        this.isShowError = isShowError;
    }

    public static  Resource error(String msg) {
        return new Resource(Status.ERROR, msg,false);
    }

    public static  Resource error(String msg,boolean isShowError) {
        return new Resource(Status.ERROR, msg,isShowError);
    }

    public static Resource loading() {
        return new Resource(Status.LOADING, null,false);
    }

    public enum Status {SUCCESS, ERROR, LOADING}
}
