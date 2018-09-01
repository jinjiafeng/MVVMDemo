package com.jjf.mvvm.data;

import com.jjf.mvvm.data.db.IDbHelper;
import com.jjf.mvvm.data.db.model.User;
import com.jjf.mvvm.data.http.IHttpHelper;
import com.jjf.mvvm.data.prefs.IPreferencesHelper;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author :jinjiafeng
 * date:  on 18-8-30
 * description:
 */
public class DataManager implements IHttpHelper,IPreferencesHelper,IDbHelper {

    private final IHttpHelper mHttpHelper;
    private final IPreferencesHelper mPreferencesHelper;
    private final IDbHelper mDbHelper;

    @Inject
    public DataManager(IHttpHelper httpHelper, IPreferencesHelper preferencesHelper, IDbHelper dbHelper) {
        this.mHttpHelper = httpHelper;
        this.mPreferencesHelper = preferencesHelper;
        this.mDbHelper = dbHelper;
    }

    @Override
    public Observable<Long> insertData(User user) {
        return null;
    }


}
