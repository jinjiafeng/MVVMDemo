package com.jjf.mvvm.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jjf.mvvm.data.db.model.DaoMaster;
import com.jjf.mvvm.data.db.model.DaoSession;
import com.jjf.mvvm.data.db.model.User;
import com.jjf.mvvm.di.ApplicationContext;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author :jinjiafeng
 * date:  on 18-8-30
 * description:
 */
public class AppDbHelper implements IDbHelper {
    private static final String DATABASE_NAME = "xj_db";
    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(@ApplicationContext Context context) {
        final SQLiteDatabase database = new DaoMaster.DevOpenHelper(context, DATABASE_NAME)
                .getWritableDatabase();
        mDaoSession = new DaoMaster(database).newSession();
    }

    @Override
    public Observable<Long> insertData(User user) {
        return Observable.fromCallable(() -> mDaoSession.insert(user));
    }
}
