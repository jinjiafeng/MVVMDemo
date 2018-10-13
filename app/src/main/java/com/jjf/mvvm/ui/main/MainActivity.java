package com.jjf.mvvm.ui.main;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jjf.mvvm.R;
import com.jjf.mvvm.base.BaseActivity;

import javax.inject.Inject;

/**
 * @author :jinjiafeng
 * date:  on 18-8-29
 * description:
 */
public class MainActivity extends BaseActivity {

    @Inject
    MainViewModel mViewModel;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        findViewById(R.id.tv_text).setOnClickListener(v ->mViewModel.sendMessage());
        mViewModel.mMsgLiveData.observe(this, new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                
            }
        });
        mViewModel.mMsgLiveData.observe(this,aLong -> {
            showContent(aLong +"");
        });
    }

    public void showContent(String msg) {
        TextView textView = findViewById(R.id.tv_text);
        textView.setText(msg);
    }
}
