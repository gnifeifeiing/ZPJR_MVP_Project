package com.zpjr.cunguan.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseFragment;
import com.zpjr.cunguan.ui.activity.login.LoginActivity;

/**
 * Description:      我的
 * Autour：          LF
 * Date：            2017/7/10 16:01
 */

public class MineFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_my, container, false);
        return mView;
    }

    @Override
    public void initView() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
