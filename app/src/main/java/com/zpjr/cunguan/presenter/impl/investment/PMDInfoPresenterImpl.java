package com.zpjr.cunguan.presenter.impl.investment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zpjr.cunguan.action.action.investment.IPMDInfoAction;
import com.zpjr.cunguan.action.impl.investment.PMDInfoActionImpl;
import com.zpjr.cunguan.adapter.PMDInfoImgAdapter;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.entity.module.LoanImagesModule;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.presenter.presenter.investment.IPMDInfoPresenter;
import com.zpjr.cunguan.ui.activity.investment.PMDInfoFragment;
import com.zpjr.cunguan.ui.activity.investment.PreviewImgActivity;
import com.zpjr.cunguan.view.investment.IPMDInfoView;

import java.util.List;

/**
 * Description:      更多详情--项目信息接presenter
 * Autour：          LF
 * Date：            2017/7/19 11:14
 */

public class PMDInfoPresenterImpl implements IPMDInfoPresenter, PresenterCallBack {

    private IPMDInfoView mView;
    private IPMDInfoAction mAction;

    private LoanImagesModule mModule;

    public PMDInfoPresenterImpl(IPMDInfoView view) {
        this.mView = view;
        this.mAction = new PMDInfoActionImpl();
    }

    @Override
    public void getCompanyImg(String loanId) {
        mAction.getCompanyImg(loanId, this);
    }

    @Override
    public void webViewInitialByContent(WebView webView, String content) {
        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setDefaultFontSize(14);
        webView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void clearWebView(WebView... webViews) {
        for (WebView view : webViews) {
            if (view != null) {
                view.removeAllViews();
                view.destroy();
            }
        }
    }

    @Override
    public void onSuccess(Object result) {
        mModule = JSON.parseObject(result.toString(), LoanImagesModule.class);
        if (mModule.isSuccess()) {
            List<LoanImagesModule.DataBean.IMAGEBean> list = mModule.getData().getIMAGE();
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mView.getRecyclerView().setLayoutManager(linearLayoutManager);
            //设置适配器
            PMDInfoImgAdapter adapter = new PMDInfoImgAdapter(mView.getContext(), list, mView.getRecyclerView());
            mView.getRecyclerView().setAdapter(adapter);
        } else {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), mModule.getErrorMessage(), SnackbarUtil.INFO).show();
        }
    }

    @Override
    public void onFail(String errMsg) {
        SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
    }
}
