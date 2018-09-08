package com.jjf.mvvm.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.jjf.mvvm.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author :jinjiafeng
 * date:  on 18-8-29
 * description:
 */
public abstract class AbstractActivity extends AppCompatActivity {
    private TextView mTvTitle;
    private Unbinder mUnbinder;
    protected Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mTvTitle = findViewById(R.id.tv_appbar_title);
        if (toolbar != null) {
            toolbar.setTitle("");
            setSupportActionBar(toolbar);
            if (isShowBackIcon()) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        }
        mContext = this;
        initView();
        initEventAndData();
    }

    /**
     * 是否显示返回按钮，默认显示，可在子类重写
     */
    public boolean isShowBackIcon() {
        return true;
    }
    /**
     * 设置layout布局，在子类重写
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图,在子类重写
     */
    protected abstract void initView();

    /**
     * 初始化数据,在子类重写
     */
    protected abstract void initEventAndData();

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
        super.onDestroy();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void startActivity(Class<? extends Activity> cls) {
        startActivity(new Intent(this, cls));
    }
}
