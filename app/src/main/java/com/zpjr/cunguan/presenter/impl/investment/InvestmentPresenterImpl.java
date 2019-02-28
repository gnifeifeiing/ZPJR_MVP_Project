package com.zpjr.cunguan.presenter.impl.investment;

import android.support.v7.widget.LinearLayoutManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zpjr.cunguan.action.action.investment.IInvestmentAction;
import com.zpjr.cunguan.action.impl.investment.InvestmentActionImpl;
import com.zpjr.cunguan.adapter.ProductListAdapter;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.CommonUtils;
import com.zpjr.cunguan.common.utils.Constants;
import com.zpjr.cunguan.common.views.LoadingDialog;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.entity.parameter.InvestmentListParameter;
import com.zpjr.cunguan.presenter.presenter.investment.IInvestmentPresenter;
import com.zpjr.cunguan.view.investment.IInvestmentListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:      产品列表presenter
 * Autour：          LF
 * Date：            2017/7/11 14:31
 */

public class InvestmentPresenterImpl extends BasePresenterImpl implements IInvestmentPresenter, PresenterCallBack {

    private LoadingDialog shapeLoadingDialog;

    private IInvestmentListView mView;
    private IInvestmentAction mAction;

    private ProductListAdapter mAdapter;
    private List<LoanModule> mList = new ArrayList<>();

    public int totalCount = 0;
    public int currentPage = 1;

    public InvestmentPresenterImpl(IInvestmentListView view) {
        this.mView = view;
        this.mAction = new InvestmentActionImpl();
    }

    @Override
    public void onRefresh() {
        totalCount = 0;
        currentPage = 1;

        mAdapter.clearData();
        getProductList();
    }

    @Override
    public void onLoadMore() {
        getProductList();
    }

    @Override
    public void getProductList() {
        showLoadingDialog(mView.getContext());
        if (totalCount % Integer.parseInt(Constants.PAGE_SIZE) != 0) {
            SnackbarUtil.ShortSnackbar(mView.getRecyclerview(), Constants.NO_MORE_DATA, SnackbarUtil.INFO).show();
            finishRefreshing();
            return;
        }
        InvestmentListParameter parameter = mView.getInvestmentListParameter();
        parameter.pageSize = Constants.PAGE_SIZE;
        parameter.currentPage = String.valueOf(currentPage);
        parameter.status = "SCHEDULED";
        parameter.minDuration = "0";
        parameter.maxDuration = String.valueOf(Integer.MAX_VALUE);
        parameter.minRate = "0";
        parameter.maxRate = String.valueOf(Integer.MAX_VALUE);
        mAction.getProductList(CommonUtils.convertToMap(parameter), this);
    }

    @Override
    public void setRecyclerviewAdapter() {
        finishRefreshing();

        if (mAdapter == null) {
            mAdapter = new ProductListAdapter(mView.getContext(), mList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mView.getContext());
            mView.getRecyclerview().setLayoutManager(layoutManager);
            mView.getRecyclerview().setAdapter(mAdapter);
        } else {
            mAdapter.setData(mList);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void finishRefreshing() {
        if (mView.getRefreshLayout().new CoContext().isRefreshing()) {
            mView.getRefreshLayout().finishRefreshing();
        }
        if (mView.getRefreshLayout().new CoContext().isLoadingMore()) {
            mView.getRefreshLayout().finishLoadmore();
        }
    }

    @Override
    public void onSuccess(Object result) {
        dismissLoadingDialog();
        JSONObject object = JSON.parseObject(result.toString());
        mList = JSON.parseArray(object.getString("results"), LoanModule.class);
        if (mList.size() > 0) {
            totalCount += mList.size();
            currentPage++;
            setRecyclerviewAdapter();
        } else {
            finishRefreshing();
            SnackbarUtil.ShortSnackbar(mView.getRecyclerview(), Constants.NO_MORE_DATA, SnackbarUtil.INFO).show();
        }
    }

    private static long mExitTime;

    @Override
    public void onFail(String errMsg) {
        dismissLoadingDialog();
        finishRefreshing();
        //避免viewpager预加载所出现弹出两次
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
            mExitTime = System.currentTimeMillis();
        }
    }
}
