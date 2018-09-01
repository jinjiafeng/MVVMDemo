package com.jjf.mvvm.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.jjf.mvvm.App;


public class ToastUtils {

    private static Toast sToast;

    public static void showShort(String s) {
        show(s, Toast.LENGTH_SHORT);
    }
    public static void showShort(@StringRes int  resId) {
        show(resId, Toast.LENGTH_SHORT);
    }

    private static void show(@StringRes int  resId, int duration) {
        final String msg = App.getInstance().getString(resId);
        show(msg, duration);
    }

    private static void show(String msg, int duration) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            showToast(msg, duration);
        } else {
            Handler mainHandler = new Handler(Looper.getMainLooper());
            mainHandler.post(() -> showToast(msg, duration));
        }
    }

    private static void showToast(String msg, int duration) {
        if (sToast != null) {
            sToast.setText(msg);
            sToast.setDuration(duration);
            sToast.show();
        } else {
            sToast = Toast.makeText(App.getInstance(), msg, duration);
            sToast.show();
        }
    }

    public static void showLong(String s) {
        show(s, Toast.LENGTH_LONG);
    }
}
