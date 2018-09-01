package com.jjf.mvvm.base;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.jjf.mvvm.App;
import com.jjf.mvvm.R;
import com.jjf.mvvm.di.component.ActivityComponent;
import com.jjf.mvvm.di.component.DaggerActivityComponent;
import com.jjf.mvvm.di.module.ActivityModule;
import com.jjf.mvvm.util.ToastUtils;

/**
 * @author :jinjiafeng
 * date:  on 18-8-29
 * description:
 */
public abstract class BaseMvpActivity extends BaseActivity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void initView() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .activityModule(new ActivityModule(this)).build();
        initInject();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    /**
     * 实现注入此Activity,子类必须实现
     */
    protected abstract void initInject();

    public void showErrorMsg(int resId) {
        showErrorMsg(getString(resId));
    }


    public void showErrorMsg(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }



    public void showMessage(String message) {
        ToastUtils.showShort(message);
    }

    public void showMessage(int resId) {
        ToastUtils.showShort(resId);
    }

    public void stateError() {

    }

    public void stateEmpty() {

    }

    public void stateLoading() {

    }

    public void stateMain() {

    }
}
