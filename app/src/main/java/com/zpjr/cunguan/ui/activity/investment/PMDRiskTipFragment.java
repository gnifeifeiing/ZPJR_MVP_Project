package com.zpjr.cunguan.ui.activity.investment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseFragment;

/**
 * Description:      更多详情--风险提示
 * Autour：          LF
 * Date：            2017/7/18 17:48
 */

public class PMDRiskTipFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.pmd_risk_tip_fragment, container, false);
        mContext = getActivity();
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
