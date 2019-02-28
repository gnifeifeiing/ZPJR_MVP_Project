package com.zpjr.cunguan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseFragment;

/**
 * Description:      首页
 * Autour：          LF
 * Date：            2017/7/10 15:54
 */
public class MainFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_main, container, false);
        return mView;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
