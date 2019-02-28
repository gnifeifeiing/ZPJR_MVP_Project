package com.zpjr.cunguan.presenter.impl.investment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.adapter.PMDViewPagerAdapter;
import com.zpjr.cunguan.common.utils.Constants;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.presenter.presenter.investment.IInvestmentPresenter;
import com.zpjr.cunguan.presenter.presenter.investment.IProductMoreDetailPresenter;
import com.zpjr.cunguan.ui.activity.investment.PMDInfoFragment;
import com.zpjr.cunguan.ui.activity.investment.PMDRecordFragment;
import com.zpjr.cunguan.ui.activity.investment.PMDRiskTipFragment;
import com.zpjr.cunguan.ui.activity.investment.ProductListFragment;
import com.zpjr.cunguan.ui.activity.investment.ProductMoreDetailActivity;
import com.zpjr.cunguan.ui.activity.main.MainActivity;
import com.zpjr.cunguan.view.fragment.IInvestFragmnetView;
import com.zpjr.cunguan.view.investment.IProductMoreDetailView;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:      更多详情--fragmentActivity
 * Autour：          LF
 * Date：            2017/7/18 17:59
 */

public class ProductMoreDetailPresenterImpl implements IProductMoreDetailPresenter, ViewPager.OnPageChangeListener {

    private Fragment mInfoFrag;
    private Fragment mRiskTipFrag;
    private Fragment mRecordFrag;

    private List<Fragment> mList=new ArrayList<>();
    private PMDViewPagerAdapter adapter;
    private TextView[] mTextViews;

    private IProductMoreDetailView mView;

    public ProductMoreDetailPresenterImpl(IProductMoreDetailView view) {
        this.mView = view;
    }

    @Override
    public void initFragment(ViewPager viewPager, TextView... textViews) {
        this.mTextViews=textViews;

        Bundle bundle=((ProductMoreDetailActivity) mView.getContext()).getIntent().getExtras();
        if(bundle==null){
            SnackbarUtil.ShortSnackbar(mView.getActivityView(),"没有数据",SnackbarUtil.INFO).show();
            ((ProductMoreDetailActivity) mView.getContext()).finish();
            return;
        }

        viewPager.setOffscreenPageLimit(2);

        mInfoFrag = new PMDInfoFragment();
        mInfoFrag.setArguments(bundle);
        mList.add(mInfoFrag);

        mRiskTipFrag = new PMDRiskTipFragment();
        mList.add(mRiskTipFrag);

        mRecordFrag = new PMDRecordFragment();
        mInfoFrag.setArguments(bundle);
        mList.add(mRecordFrag);

        adapter=new PMDViewPagerAdapter(((ProductMoreDetailActivity) mView.getContext()).getSupportFragmentManager(),mList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);

        //初始化选中状态
        setSelectedItem(0);
    }

    @Override
    public void onClick(View view,ViewPager viewPager) {
        switch (view.getId()){
            case R.id.moreDetail_infoTv:
                viewPager.setCurrentItem(0);
                setSelectedItem(0);
                break;
            case R.id.moreDetail_riskTipTv:
                viewPager.setCurrentItem(1);
                setSelectedItem(1);
                break;
            case R.id.moreDetail_recordTv:
                viewPager.setCurrentItem(2);
                setSelectedItem(2);
                break;
        }
    }

    private void setSelectedItem(int position){
        switch (position){
            case 0:
                mTextViews[0].setTextColor(Color.parseColor("#ff7a0f"));
                mTextViews[1].setTextColor(Color.parseColor("#808080"));
                mTextViews[2].setTextColor(Color.parseColor("#808080"));
                break;
            case 1:
                mTextViews[0].setTextColor(Color.parseColor("#808080"));
                mTextViews[1].setTextColor(Color.parseColor("#ff7a0f"));
                mTextViews[2].setTextColor(Color.parseColor("#808080"));
                break;
            case 2:
                mTextViews[0].setTextColor(Color.parseColor("#808080"));
                mTextViews[1].setTextColor(Color.parseColor("#808080"));
                mTextViews[2].setTextColor(Color.parseColor("#ff7a0f"));
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setSelectedItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
