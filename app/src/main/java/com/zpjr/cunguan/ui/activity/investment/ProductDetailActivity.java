package com.zpjr.cunguan.ui.activity.investment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.common.utils.DealDate;
import com.zpjr.cunguan.common.utils.GetTransInformation;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.common.utils.StatusString;
import com.zpjr.cunguan.common.views.TimeTextView;
import com.zpjr.cunguan.entity.enums.LoanStatus;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.view.investment.IProductDetailView;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * Description:      项目详情
 * Autour：          LF
 * Date：            2017/7/18 11:15
 */
public class ProductDetailActivity extends BaseActivity implements IProductDetailView, View.OnClickListener {

    private TextView mBaseRateTv;
    private TextView mDetailRateTv;
    private TextView mBaiHaoTv;
    //投资期限的单位-天，月，年
    private TextView mDetailDanweiTv;
    //投资期限
    private TextView mDetailLimitTv;
    //进度
    private TextView mDetailScaleTv;
    //可投金额
    private TextView mDetailBalanceTv;
    //融资金额
    private TextView mAmountTv;
    //项目标题
    private TextView mLoanTitleTv;
    //剩余时间
    private TextView mYuTimeTv;
    //剩余时间
    private TextView mTvtextTv;
    //剩余时间
    private TimeTextView timeTextView;

    //还款方式
    private TextView mDetailReturntypeTv;
    //起投金额
    private TextView mStartInvestAmountTv;
    //投资限额
    private TextView mInvestLimitTv;
    //计息方式
    private TextView mProfitTypeTv;

    //查看更多
    private TextView mDetailTv;
    //立即投资
    private TextView mTouziTv;
    //立即投资
    private LinearLayout mTouziLl;

    /*************************变量命名区*********************/
    private LoanModule mLoanModule;

    public String fromInvest;
    private double canInvestMoey;

    private boolean fundFinish = false;
    private boolean couponFinish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setActionBarTitle("项目详情");
        initView();
        initListener();
        getLoanModule();
        setViewModule();
    }

    @Override
    public void initView() {
        mBaseRateTv= (TextView) findViewById(R.id.produceDetail_baseRateTv);
        mDetailRateTv= (TextView) findViewById(R.id.produceDetail_detailRateTv);
        mBaiHaoTv= (TextView) findViewById(R.id.produceDetail_baiHaoTv);
        mDetailDanweiTv= (TextView) findViewById(R.id.produceDetail_detailDanweiTv);
        mDetailLimitTv= (TextView) findViewById(R.id.produceDetail_detailLimitTv);
        mDetailScaleTv= (TextView) findViewById(R.id.productDetail_detailScaleTv);
        mDetailBalanceTv= (TextView) findViewById(R.id.productDetail_detailBalanceTv);

        mAmountTv= (TextView) findViewById(R.id.productDetail_amountTv);
        mLoanTitleTv= (TextView) findViewById(R.id.productDetail_loanTitleTv);
        mYuTimeTv= (TextView) findViewById(R.id.productDetail_yuTimeTv);
        mTvtextTv= (TextView) findViewById(R.id.productDetail_tvtextTv);
        mTouziTv= (TextView) findViewById(R.id.produceDetail_touziTv);
        timeTextView= (TimeTextView) findViewById(R.id.timeTextView);

        mDetailReturntypeTv= (TextView) findViewById(R.id.productDetail_detailReturntypeTv);
        mStartInvestAmountTv= (TextView) findViewById(R.id.productDetail_startInvestAmountTv);
        mInvestLimitTv= (TextView) findViewById(R.id.productDetail_investLimitTv);
        mProfitTypeTv= (TextView) findViewById(R.id.productDetail_profitTypeTv);

        mDetailTv= (TextView) findViewById(R.id.productDetail_detailTv);
        mTouziLl= (LinearLayout) findViewById(R.id.produceDetail_touziLl);
    }

    @Override
    public void initListener() {
        mDetailTv.setOnClickListener(this);
    }

    @Override
    public void getLoanModule() {
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            mLoanModule= (LoanModule) bundle.getSerializable(ProductListFragment.class.getName());
        }
    }

    @Override
    public void setViewModule() {
        //项目标题
        mLoanTitleTv.setText(mLoanModule.getTitle());
        /**
         * 是否显示投资按钮，否则显示查看详情
         */
        if (mLoanModule.getStatus().equals("SETTLED")||mLoanModule.getStatus().equals("CLEARED")||mLoanModule.getStatus().equals("FINISHED")){
            mTouziLl.setVisibility(View.GONE);
        }
        if (mLoanModule.getStatus().equals("OPENED")||mLoanModule.getStatus().equals("SCHEDULED")){
            mTouziLl.setVisibility(View.VISIBLE);
        }
        /**
         * 百分比收益
         */
        if (mLoanModule.getLoanRequest().getDeductionRate() == 0 && mLoanModule.getLoanRequest().getFloatingInterestRate() == 0) {
            mDetailRateTv.setVisibility(View.GONE);
            mBaiHaoTv.setVisibility(View.GONE);
            mBaseRateTv.setText(GetTransInformation.deleteZeroOfEnd((mLoanModule.getRate() - mLoanModule.getLoanRequest().getDeductionRate()) / 100.0) + "%");
        } else if (mLoanModule.getLoanRequest().getDeductionRate() != 0) {
            mDetailRateTv.setVisibility(View.VISIBLE);
            mBaiHaoTv.setVisibility(View.VISIBLE);
            mBaseRateTv.setText(GetTransInformation.deleteZeroOfEnd((mLoanModule.getRate() - mLoanModule.getLoanRequest().getDeductionRate()) / 100.0) + "%");
            mDetailRateTv.setText("+" + GetTransInformation.deleteZeroOfEnd(mLoanModule.getLoanRequest().getDeductionRate() / 100.0));
        } else if (mLoanModule.getLoanRequest().getFloatingInterestRate() != 0) {
            mDetailRateTv.setVisibility(View.VISIBLE);
            mBaiHaoTv.setVisibility(View.VISIBLE);
            mBaseRateTv.setText(GetTransInformation.deleteZeroOfEnd((mLoanModule.getRate() - mLoanModule.getLoanRequest().getDeductionRate()) / 100.0) + "%");
            mDetailRateTv.setText("+" + GetTransInformation.deleteZeroOfEnd(mLoanModule.getLoanRequest().getFloatingInterestRate() / 100.0));
        }
        //还款方式
        mDetailReturntypeTv.setText(StatusString.getRepaymentMode(mLoanModule.getMethod()));
        //计息方式
        mProfitTypeTv.setText("结标次日计息");
        //起投金额
        mStartInvestAmountTv.setText(mLoanModule.getLoanRequest().getInvestRule().getMinAmount() + "元");
        //投资限额
        mInvestLimitTv.setText(mLoanModule.getLoanRequest().getInvestRule().getMaxAmount() + "元");
        /**
         * 可投金额
         */
        DecimalFormat df = new DecimalFormat("#.00");
        canInvestMoey =(Double.parseDouble(String.valueOf((mLoanModule.getAmount().subtract(mLoanModule.getInvestAmount())))))/10000;
        if (100 > Double.parseDouble(String.valueOf((mLoanModule.getAmount().subtract(mLoanModule.getInvestAmount()))))){
            mDetailBalanceTv.setText("0.00");
        }else if (10000>Double.parseDouble(String.valueOf((mLoanModule.getAmount().subtract(mLoanModule.getInvestAmount()))))){
            mDetailBalanceTv.setText("0"+String.valueOf(df.format(canInvestMoey)));
        }else {
            mDetailBalanceTv.setText(String.valueOf(df.format(canInvestMoey)));
        }
        //已投比例--圆形
        mDetailScaleTv.setText(String.valueOf(Integer.parseInt(new DecimalFormat("0").format(mLoanModule.getInvestPercent())))+"%");
        //融资金额
        mAmountTv.setText(String.valueOf("/"+Integer.valueOf(String.valueOf(mLoanModule.getAmount()))/10000+"万"));
        /**
         * 投资期限
         */
        if (mLoanModule.getDuration().getDays() != 0) {
            if ("FLOATING".equals(mLoanModule.loanRequest.getDurationType())) {
                mDetailLimitTv.setText(String.format(getString(R.string.product_floating_day), mLoanModule.getLoanRequest().getMinDurationDays(), mLoanModule.getDuration()
                        .getDays()));
                mDetailDanweiTv.setText("天");
            } else {
                mDetailLimitTv.setText(String.format(this
                        .getString(R.string.product_limit_tian), mLoanModule.getDuration()
                        .getTotalDays()));
                mDetailDanweiTv.setText("天");
            }

        } else {
            mDetailLimitTv.setText(String.format(this.getString(R.string.product_limit_yue),
                    mLoanModule.getDuration().getTotalMonths()));
            mDetailDanweiTv.setText("个月");
        }
        /**
         * 立即投资textview
         */
        mTouziTv.setText(StatusString.getTouziStatus(mLoanModule.getStatus()));
        if (mLoanModule.getStatus().equals(LoanStatus.OPENED.name())) {//productDetail
            /**
             * 此处代码先注释
             */
            /*//是否投过新手专享的判断
            if (fromInvest.equals("investInvest")) {//我的投资详情中过来的
                mTouziTv.setVisibility(View.VISIBLE);
            } else {
                if (mLoanModule.getLoanRequest().getProductKey().equals("XSZX")) {
                    getMyProductList();
                    mTouziTv.setBackgroundResource(R.drawable.btn_blue);
                    mTouziTv.setTextColor(this.getResources().getColor(R.color.white));

                } else {
                    mTouziTv.setBackgroundResource(R.drawable.btn_blue);
                    mTouziTv.setTextColor(this.getResources().getColor(R.color.white));
                    mTouziTv.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // 立即投资
                            fundFinish = false;
                            couponFinish = false;
                            getInfo();
                        }
                    });
                }
            }*/
        } else {
            if (mLoanModule.getStatus().equals(LoanStatus.SCHEDULED.name())) {
                mTouziTv.setBackgroundColor(this.getResources().getColor(R.color.blue));
                mTouziTv.setTextColor(this.getResources().getColor(
                        R.color.skyblue));
                mTouziTv.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SnackbarUtil.ShortSnackbar(mTouziTv,"抢投即将开始，敬请期待",SnackbarUtil.INFO).show();
                    }
                });
            } else if (mLoanModule.getStatus().equals(LoanStatus.SETTLED.name())
                    || mLoanModule.getStatus().equals(LoanStatus.CLEARED.name())
                    || mLoanModule.getStatus().equals(LoanStatus.OVERDUE.name())
                    || mLoanModule.getStatus().equals(LoanStatus.BREACH.name())
                    || mLoanModule.getStatus().equals(LoanStatus.FROZEN.name())
                    || mLoanModule.getStatus().equals(LoanStatus.FINISHED.name())) {
                mTouziTv.setVisibility(View.VISIBLE);
            } else {
                mTouziTv.setBackgroundResource(R.drawable.btn_enable);
                mTouziTv.setTextColor(this.getResources().getColor(
                        R.color.white));
                mTouziTv.setEnabled(false);
            }
        }
        /**
         * 剩余时长
         */
        long timeFinish;
        long timeOpen;
        long timeOut;
        try {
            timeOut = mLoanModule.getTimeout() * 60 * 60 * 1000;
        } catch (NullPointerException e) {
            timeOut = 0;
        }
        try {
            timeFinish = mLoanModule.getTimeFinished();
        } catch (NullPointerException e) {
            timeFinish = 0;
        }
        try {
            timeOpen = mLoanModule.getTimeOpen();
        } catch (NullPointerException e) {
            timeOpen = 0;
        }
        String label = "于" + DealDate.dateToString(new Date(timeFinish), "yyyy-MM-dd HH:mm") + "售完";
        timeTextView.setLast(true, label);
        //System.out.println(mLoanModule.getStatus() + "  ---   " + LoanStatus.OPENED.name());
        if (mLoanModule.getStatus().equals(LoanStatus.OPENED.name())) {
            timeTextView.setVisibility(View.VISIBLE);
            timeTextView.setLast(false, "");//截至
            timeTextView.setTimes(timeOpen + timeOut - System.currentTimeMillis());
            timeTextView.start();
            mTvtextTv.setVisibility(View.GONE);
        } else if (mLoanModule.getStatus().equals(LoanStatus.SCHEDULED.name())) {
            timeTextView.setVisibility(View.VISIBLE);
            timeTextView.setLast(false, "开始");
            timeTextView.setTimes(timeOpen - System.currentTimeMillis());
            timeTextView.start();
            mTvtextTv.setVisibility(View.GONE);
        } else if (mLoanModule.getStatus().equals(LoanStatus.SETTLED.name()) || mLoanModule.getStatus().equals(LoanStatus.CLEARED.name())) {
            mTvtextTv.setVisibility(View.VISIBLE);
            timeTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public View getActivityView() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //更多详情
            case R.id.productDetail_detailTv:
                Intent intent=new Intent(this, ProductMoreDetailActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable(ProductListFragment.class.getName(),mLoanModule);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}
