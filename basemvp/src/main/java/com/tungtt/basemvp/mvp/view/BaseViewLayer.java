package com.tungtt.basemvp.mvp.view;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import com.tungtt.basemvp.mvp.presenter.IBasePresenterLayer;

/**
 * Created by ttcandroid a.k.a TungTT
 * On Wed, 21 Oct 2020 - 15:50
 */
public abstract class BaseViewLayer<P extends IBasePresenterLayer>
        implements IBaseViewLayer<P> {

    private P mPresenter;

    public P mPresenter() {
        return mPresenter;
    }

    public void initPresenterLayer(P presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public Activity mActivity() {
        if (mPresenter instanceof Activity) {
            return (Activity) mPresenter;
        } else if (mPresenter instanceof Fragment) {
            return ((Fragment) mPresenter).getActivity();
        } else {
            return null;
        }
    }
}
