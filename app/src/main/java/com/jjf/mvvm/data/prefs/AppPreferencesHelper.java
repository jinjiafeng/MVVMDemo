package com.jjf.mvvm.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.jjf.mvvm.di.ApplicationContext;

import javax.inject.Inject;

/**
 * @author :jinjiafeng
 * date:  on 18-8-30
 * description:
 */
public class AppPreferencesHelper implements IPreferencesHelper {

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private static final String PREF_NAME = "xj_pref";
    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context) {
        mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
}
