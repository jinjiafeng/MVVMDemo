package com.jjf.mvvm.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jjf.mvvm.R;

import javax.inject.Inject;

import static com.jjf.mvvm.data.http.Resource.Status;
import static com.jjf.mvvm.data.http.Resource.Status.ERROR;
import static com.jjf.mvvm.data.http.Resource.Status.LOADING;
import static com.jjf.mvvm.data.http.Resource.Status.SUCCESS;

/**
 * @author :jinjiafeng
 * date:  on 18-8-30
 * description: 根据不同的状态 loading , error or main 加载不同的视图
 */
public abstract class BaseRootActivity<VM extends BaseViewModel> extends BaseMvpActivity {
    @Inject
    VM viewModel;
    private ImageView ivLoading;
    private View viewError;
    private View viewLoading;
    private ViewGroup viewMain;
    private ViewGroup mParent;

    private int mErrorResource = R.layout.view_error;

    private Status currentState = SUCCESS;
    private boolean isErrorViewAdded = false;

    @Override
    protected void initEventAndData() {
        viewMain = findViewById(R.id.view_main);
        if (viewMain == null) {
            throw new IllegalStateException(
                    "The subclass of RootActivity must contain a View named 'view_main'.");
        }
        if (!(viewMain.getParent() instanceof ViewGroup)) {
            throw new IllegalStateException(
                    "view_main's ParentView should be a ViewGroup.");
        }
        mParent = (ViewGroup) viewMain.getParent();
        View.inflate(this, R.layout.view_progress, mParent);
        viewLoading = mParent.findViewById(R.id.view_loading);
        ivLoading = viewLoading.findViewById(R.id.iv_progress);
        viewLoading.setVisibility(View.GONE);
        viewMain.setVisibility(View.VISIBLE);

        viewModel.getState().observe(this, resource -> {
            if(resource == null){
                return;
            }
            switch (resource.status) {
                case SUCCESS:
                    stateMain();
                    break;
                case LOADING:
                  stateLoading();
                    break;
                case ERROR:
                   stateError();
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public void stateError() {
        if (currentState == SUCCESS) {
            return;
        }
        if (!isErrorViewAdded) {
            isErrorViewAdded = true;
            View.inflate(mContext, mErrorResource, mParent);
            viewError = mParent.findViewById(R.id.view_error);
            if (viewError == null) {
                throw new IllegalStateException(
                        "A View should be named 'view_error' in ErrorLayoutResource.");
            }
        }
        hideCurrentView();
        currentState = ERROR;
        viewError.setVisibility(View.VISIBLE);
    }

    @Override
    public void stateLoading() {
        if (currentState == LOADING) {
            return;
        }
        hideCurrentView();
        currentState = LOADING;
        viewLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void stateMain() {
        if (currentState == SUCCESS) {
            return;
        }
        hideCurrentView();
        currentState = SUCCESS;
        viewMain.setVisibility(View.VISIBLE);
    }

    private void hideCurrentView() {
        switch (currentState) {
            case SUCCESS:
                viewMain.setVisibility(View.GONE);
                break;
            case LOADING:
                //                ivLoading.stop();
                viewLoading.setVisibility(View.GONE);
                break;
            case ERROR:
                if (viewError != null) {
                    viewError.setVisibility(View.GONE);
                }
                break;
            default:
                break;
        }
    }

    public void setErrorResource(int errorLayoutResource) {
        this.mErrorResource = errorLayoutResource;
    }
}
