package com.zpjr.cunguan.ui.activity.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Description:      帮助中心
 * Autour：          LF
 * Date：            2017/8/22 10:49
 */
public class HelpActivity extends BaseActivity implements View.OnClickListener {

    private Button mAboutAppBtn;
    private Button mProductIntroduceBtn;
    private Button mRiskControlBtn;
    private Button mRegisterLoginBtn;
    private Button mUploadWithdrawBtn;
    private Button mMemberIntegralBtn;
    private Button mInvestmentFinancingBtn;
    private Button mTerminologyBtn;
    private Button mLawSafetyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setActionBarTitle("帮助中心");
        initView();
        initListener();
    }

    private void initListener() {
        mAboutAppBtn.setOnClickListener(this);
        mProductIntroduceBtn.setOnClickListener(this);
        mRiskControlBtn.setOnClickListener(this);
        mRegisterLoginBtn.setOnClickListener(this);
        mUploadWithdrawBtn.setOnClickListener(this);
        mMemberIntegralBtn.setOnClickListener(this);
        mInvestmentFinancingBtn.setOnClickListener(this);
        mTerminologyBtn.setOnClickListener(this);
        mLawSafetyBtn.setOnClickListener(this);
    }

    private void initView() {
        mAboutAppBtn= (Button) findViewById(R.id.help_aboutAppBtn);
        mProductIntroduceBtn= (Button) findViewById(R.id.help_productIntroduceBtn);
        mRiskControlBtn= (Button) findViewById(R.id.help_riskControlBtn);
        mRegisterLoginBtn= (Button) findViewById(R.id.help_registerLoginBtn);
        mUploadWithdrawBtn= (Button) findViewById(R.id.help_uploadWithdrawBtn);
        mMemberIntegralBtn= (Button) findViewById(R.id.help_memberIntegralBtn);
        mInvestmentFinancingBtn= (Button) findViewById(R.id.help_investmentFinancingBtn);
        mTerminologyBtn= (Button) findViewById(R.id.help_terminologyBtn);
        mLawSafetyBtn= (Button) findViewById(R.id.help_lawSafetyBtn);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.help_aboutAppBtn:
                //WebViewActivity.startAc(this, WebViewActivity.ABOUT_App);
                useUTF8ForRequest(getResources().getString(R.string.aboutApp));
                break;
            case R.id.help_productIntroduceBtn:
                //WebViewActivity.startAc(this, WebViewActivity.PRODUCT_INTRODUCE);
                useUTF8ForRequest("产品介绍");
                break;
            case R.id.help_riskControlBtn:
                //WebViewActivity.startAc(this, WebViewActivity.RISK_CONTROL);
                useUTF8ForRequest("风控安全");
                break;
            case R.id.help_registerLoginBtn:
                //WebViewActivity.startAc(this, WebViewActivity.REGISTER_LOGIN);
                useUTF8ForRequest("注册/登录");
                break;
            case R.id.help_uploadWithdrawBtn:
                //WebViewActivity.startAc(this, WebViewActivity.UPLOAD_WITHDRAW);
                useUTF8ForRequest("充值/提现");
                break;
            case R.id.help_memberIntegralBtn:
                //WebViewActivity.startAc(this, WebViewActivity.MEMBER_INTEGRAL);
                useUTF8ForRequest("会员/积分");
                break;
            case R.id.help_investmentFinancingBtn:
                //WebViewActivity.startAc(this, WebViewActivity.INVESTMENT_FINANCING);
                useUTF8ForRequest("投资理财");
                break;
            case R.id.help_terminologyBtn:
                //WebViewActivity.startAc(this, WebViewActivity.TERMINOLOGY);
                useUTF8ForRequest("名词解释");
                break;
            case R.id.help_lawSafetyBtn:
                //WebViewActivity.startAc(this, WebViewActivity.LAW_SAFETY);
                useUTF8ForRequest("法律安全");
                break;
        }
    }

    public void useUTF8ForRequest(String item)
    {
        Intent intent = new Intent(this, CMSWebViewActivity.class);
        intent.putExtra("title", item);
        intent.putExtra("url", item);
        startActivity(intent);
    }
}
