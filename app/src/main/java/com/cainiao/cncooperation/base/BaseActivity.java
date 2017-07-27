package com.cainiao.cncooperation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hc on 2017/7/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mBind;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initArgs(getIntent().getExtras())) {
            setContentView(setLayoutId());
            initView();
            initListener();
            initData();
        }else {
            finish();
        }
    }

    /**
     * 初始化窗口
     * @param bundle  数据
     * @return  如果初始化成功  返回true
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /***
     * 设置监听器
     */
    protected void initListener() {}

    /***
     * 设置view
     */
    protected void initView() {
        //绑定ButterKnife
        mBind = ButterKnife.bind(this);
    }

    /***
     * 设置数据
     */
    protected void initData() {}


    /***
     * 设置布局文件
     * @return
     */
    protected abstract int setLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null){
            mBind.unbind();
        }
    }

}
