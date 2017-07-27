package com.cainiao.cncooperation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cainiao.cncooperation.R;

import butterknife.BindView;

/**
 * Created by Hc on 2017/7/22.
 */

public class HomeFragment extends BaseFragment {

    @BindView( R.id.fragment_content )
    public TextView tv_content ;

    @Override
    public int setLayoutView() {
        return R.layout.home_fragment_layout;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        tv_content.setText("Test HomeFragment");
    }
}
