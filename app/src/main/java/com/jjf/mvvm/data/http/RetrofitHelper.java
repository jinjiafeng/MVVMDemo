package com.jjf.mvvm.data.http;

import javax.inject.Inject;

/**
 * @author :jinjiafeng
 * date:  on 18-8-30
 * description:
 */
public class RetrofitHelper implements IHttpHelper {

    private final XjApis mXjApiService;

    @Inject
    public RetrofitHelper(XjApis xjApis) {
        this.mXjApiService = xjApis;
    }

}
