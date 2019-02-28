package com.zpjr.cunguan.ui.activity.investment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.presenter.impl.investment.ProductMoreDetailPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.investment.IProductMoreDetailPresenter;
import com.zpjr.cunguan.view.investment.IProductMoreDetailView;

/**
 * Description:      更多详情
 * Autour：          LF
 * Date：            2017/7/18 17:12
 */
public class ProductMoreDetailActivity extends BaseActivity implements IProductMoreDetailView, View.OnClickListener {

    private ViewPager mViewPager;
    private TextView mInfoTv;
    private TextView mRiskTipTv;
    private TextView mRecordTv;

    private IProductMoreDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_more_detail);
        setActionBarTitle("更多详情");
        presenter = new ProductMoreDetailPresenterImpl(this);
        initView();
        initListener();
        initFragment();
    }

    @Override
    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.moreDetail_viewPager);
        mInfoTv = (TextView) findViewById(R.id.moreDetail_infoTv);
        mRiskTipTv = (TextView) findViewById(R.id.moreDetail_riskTipTv);
        mRecordTv = (TextView) findViewById(R.id.moreDetail_recordTv);
    }

    @Override
    public void initListener() {
        mInfoTv.setOnClickListener(this);
        mRiskTipTv.setOnClickListener(this);
        mRecordTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        presenter.onClick(view, mViewPager);
    }

    @Override
    public void initFragment() {
        presenter.initFragment(mViewPager, mInfoTv, mRiskTipTv, mRecordTv);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getActivityView() {
        return mViewPager;
    }

}
