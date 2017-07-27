package com.cainiao.cncooperation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hc on 2017/7/25.
 */

public abstract class BaseFragment extends Fragment {

    private View mRoot;
    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = mRoot;
        if (mRoot == null) {
            int layoutId = setLayoutView();
            mView = inflater.inflate(layoutId, container, false);
            mRoot = mView;
            initView(mView);
            initListener();
            initData();
        } else {
            if (mRoot.getParent() != null) {
                //把当前root从其父控件中移除
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot = mView;
    }

    /**
     * 初始化view
     * @param view
     */
    protected void initView(View view) {
        mBind = ButterKnife.bind(this,view);
    }


    /***
     * 初始化数据
     */
    protected void initData(){};

    /***
     * 初始化监听器
     */
    protected void initListener(){};

    /***
     * 设置该界面的view
     * @return
     */
    public abstract int setLayoutView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mRoot != null) {
            if (mBind != null)
                mBind.unbind();
            mRoot = null;
        }
    }
}
