package com.zpjr.cunguan.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseFragment;
import com.zpjr.cunguan.common.views.WDTabPageIndicator;
import com.zpjr.cunguan.presenter.impl.fragment.InvestFragmentPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.fragment.IInvestFragmentPresenter;
import com.zpjr.cunguan.view.fragment.IInvestFragmnetView;

/**
 * Description:      投资(产品列表)
 * Autour：          LF
 * Date：            2017/7/10 16:00
 */

public class InvestFragment extends BaseFragment implements IInvestFragmnetView {

    private WDTabPageIndicator mIndicator;
    private ViewPager mViewPager;

    private IInvestFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_investment, container, false);
        mContext = getActivity();
        presenter = new InvestFragmentPresenterImpl(this);
        return mView;
    }

    @Override
    public void initView() {
        mIndicator = mView.findViewById(R.id.indicator);
        mViewPager = mView.findViewById(R.id.view_pager);
    }


    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        presenter.initFragment(mViewPager, mIndicator);
    }

    @Override
    public View getActivityView() {
        return mViewPager;
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
