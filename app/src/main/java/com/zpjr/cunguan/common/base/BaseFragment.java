package com.zpjr.cunguan.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/10 15:56
 */
public abstract class BaseFragment extends Fragment {

    public View mView;
    public Context mContext;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
        initData();
    }

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化事件
     */
    public abstract void initListener();

    /**
     * 初始化数据
     */
    public abstract void initData();
}
