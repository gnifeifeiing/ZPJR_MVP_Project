package com.zpjr.cunguan.ui.activity.investment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.BallPulseView;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.GoogleDotView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.adapter.ProductListAdapter;
import com.zpjr.cunguan.common.base.BaseFragment;
import com.zpjr.cunguan.common.utils.Constants;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.entity.parameter.InvestmentListParameter;
import com.zpjr.cunguan.presenter.impl.investment.InvestmentPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.investment.IInvestmentPresenter;
import com.zpjr.cunguan.view.investment.IInvestmentListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:      产品列表
 * Autour：          LF
 * Date：            2017/7/12 16:23
 */

public class ProductListFragment extends BaseFragment implements IInvestmentListView {

    public TwinklingRefreshLayout mRefreshLayout;
    private RecyclerView mRlv;
    //列表请求参数
    private InvestmentListParameter mParameter;

    private IInvestmentPresenter mPresenter;

    //产品类型
    private String mProductType = Constants.ASY;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_product_list, container, false);
        mPresenter = new InvestmentPresenterImpl(this);
        mContext = getActivity();
        Bundle bundle = getArguments();
        if (bundle != null) {
            mProductType = bundle.getString("product_type");
        }
        return mView;
    }

    @Override
    public void initView() {
        mRlv = mView.findViewById(R.id.productList_Rlv);
        mRefreshLayout = mView.findViewById(R.id.productList_refreshLayout);
        //支持切换到像SwipeRefreshLayout一样的悬浮刷新模式了。
        //mRefreshLayout.setFloatRefresh(true);
        //设置头部view样式：GoogleDotView，BezierLayout，SinaRefreshView，ProgressLayout，
        mRefreshLayout.setHeaderView(new ProgressLayout(mContext));
        //设置footerview样式:BallPulseView,LoadingView
        mRefreshLayout.setBottomView(new BallPulseView(mContext));
        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                mPresenter.onRefresh();
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                mPresenter.onLoadMore();
            }
        });
        mPresenter.setRecyclerviewAdapter();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mPresenter.getProductList();
    }

    @Override
    public InvestmentListParameter getInvestmentListParameter() {
        mParameter = new InvestmentListParameter();
        mParameter.product = mProductType;
        return mParameter;
    }

    @Override
    public TwinklingRefreshLayout getRefreshLayout() {
        return mRefreshLayout;
    }

    @Override
    public RecyclerView getRecyclerview() {
        return mRlv;
    }

    @Override
    public View getActivityView() {
        return mRefreshLayout;
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
