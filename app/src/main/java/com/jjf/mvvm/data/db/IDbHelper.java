package com.jjf.mvvm.data.db;


import com.jjf.mvvm.data.db.model.User;

import io.reactivex.Observable;

/**
 * @author :jinjiafeng
 * date:  on 18-8-30
 * description: 数据库使用
 */
public interface IDbHelper {
    /**
     *
     * @return 可观察对象,配合RxJava 方便切换线程
     */
    Observable<Long> insertData(User user);
}
