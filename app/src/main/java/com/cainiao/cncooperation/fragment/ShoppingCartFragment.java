package com.cainiao.cncooperation.fragment;

import android.view.View;
import android.widget.TextView;

import com.cainiao.cncooperation.R;
import com.cainiao.cncooperation.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by hc on 2017/7/25.
 */

public class ShoppingCartFragment extends BaseFragment {

    @BindView( R.id.fragment_content )
    public TextView tv_content ;

    @Override
    public int setLayoutView() {
        return R.layout.home_fragment_layout;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        tv_content.setText("Test ShoppingCartFragment");
    }
}
