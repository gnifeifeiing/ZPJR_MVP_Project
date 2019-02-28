package com.zpjr.cunguan.ui.activity.investment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseFragment;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.presenter.impl.investment.InvestmentPresenterImpl;
import com.zpjr.cunguan.presenter.impl.investment.PMDInfoPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.investment.IPMDInfoPresenter;
import com.zpjr.cunguan.view.investment.IPMDInfoView;

/**
 * Description:      更多详情--项目详情
 * Autour：          LF
 * Date：            2017/7/18 17:44
 */

public class PMDInfoFragment extends BaseFragment implements IPMDInfoView {

    private ScrollView mSlv;

    private TextView mThisAllMoneyTv;
    private TextView mThisLimitTimeTv;

    private WebView mCompanyProfilesWv;
    private WebView mLoanExplainWv;
    private WebView mGuaranteeMessageWv;
    private WebView mRiskControlWv;

    private RecyclerView mHorizontalRlv;

    private LoanModule mLoan;
    private IPMDInfoPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.pmd_info_fragment, container, false);
        presenter=new PMDInfoPresenterImpl(this);
        mContext = getActivity();
        return mView;
    }

    @Override
    public void initView() {
        mSlv = mView.findViewById(R.id.pdmInfo_slv);

        mThisAllMoneyTv = mView.findViewById(R.id.pmdInfo_thisAllMoneyTv);
        mThisLimitTimeTv = mView.findViewById(R.id.pmdInfo_thisLimitTimeTv);

        mCompanyProfilesWv = mView.findViewById(R.id.pmdInfo_companyProfilesWv);
        mLoanExplainWv = mView.findViewById(R.id.pmdInfo_loanExplainWv);
        mGuaranteeMessageWv = mView.findViewById(R.id.pmdInfo_guaranteeMessageWv);
        mRiskControlWv = mView.findViewById(R.id.pmdInfo_riskControlWv);

        mHorizontalRlv = mView.findViewById(R.id.pmdInfo_horizontalRlv);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mLoan = (LoanModule) bundle.getSerializable(ProductListFragment.class.getName());
            setViewData();
            getCompanyImg();
        }
    }

    @Override
    public void setViewData() {
        mThisAllMoneyTv.setText(String.valueOf(Integer.valueOf(String.valueOf(mLoan.getAmount())) / 10000 + "万"));
        if (mLoan.getDuration().getDays() != 0) {
            if ("FLOATING".equals(mLoan.loanRequest.getDurationType())) {
                mThisLimitTimeTv.setText(String.format(getString(R.string.product_floating_day_new), mLoan.getLoanRequest().getMinDurationDays(), mLoan.getDuration()
                        .getDays()));
            } else {
                mThisLimitTimeTv.setText(String.format(this
                        .getString(R.string.product_limit_day_new), mLoan.getDuration()
                        .getTotalDays()));
            }
        } else {
            mThisLimitTimeTv.setText(String.format(this.getString(R.string.product_limit_new),
                    mLoan.getDuration().getTotalMonths()));
        }

        presenter.webViewInitialByContent(mCompanyProfilesWv, mLoan.getLoanRequest().getMortgageInfo());
        presenter.webViewInitialByContent(mLoanExplainWv, mLoan.getLoanRequest().getDescription());
        presenter.webViewInitialByContent(mRiskControlWv, mLoan.getLoanRequest().getRiskInfo());
        presenter.webViewInitialByContent(mGuaranteeMessageWv, mLoan.getLoanRequest().getGuaranteeInfo());

    }

    @Override
    public void getCompanyImg() {
        presenter.getCompanyImg(mLoan.getId());
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mHorizontalRlv;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.clearWebView(mCompanyProfilesWv, mLoanExplainWv, mRiskControlWv, mGuaranteeMessageWv);
    }

    @Override
    public View getActivityView() {
        return mSlv;
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
