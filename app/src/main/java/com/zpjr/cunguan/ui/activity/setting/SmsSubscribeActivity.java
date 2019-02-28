package com.zpjr.cunguan.ui.activity.setting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.presenter.impl.setting.SmsSubscribePresenterImpl;
import com.zpjr.cunguan.presenter.presenter.setting.ISmsSubscribePresenter;
import com.zpjr.cunguan.view.setting.ISmsSubscribeView;

/**
 * Description:      短信订阅
 * Autour：          LF
 * Date：            2017/8/22 16:12
 */
public class SmsSubscribeActivity extends BaseActivity implements View.OnClickListener,ISmsSubscribeView {

    private TextView mTipTv;
    private Button mSureSubscribeBtn;
    private int mSubscribeState;

    private ISmsSubscribePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_subscribe);
        setActionBarTitle("营销短信订阅");
        mPresenter=new SmsSubscribePresenterImpl(this);
        initView();
        initListener();
        initIntent();
    }

    private void initListener() {
        mSureSubscribeBtn.setOnClickListener(this);
    }

    private void initView() {
        mTipTv = (TextView) findViewById(R.id.smsSubscribe_tipTv);
        mSureSubscribeBtn = (Button) findViewById(R.id.smsSubscribe_sureSubscribeBtn);
    }

    private void initIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mSubscribeState = bundle.getInt("subscribe");
            //未订阅
            if (mSubscribeState == 0) {
                mSureSubscribeBtn.setText("点击订阅");
                mTipTv.setText("您尚未订阅我平台的营销短信");
            } else {
                mSureSubscribeBtn.setText("取消订阅");
                mTipTv.setText("您已订阅我平台的营销短信");
            }
        }
    }

    private void changeSubscribe() {
        //未订阅
        if (mSubscribeState == 0) {
            mPresenter.isSubscribeSms("1");
        } else {
            mPresenter.isSubscribeSms("0");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.smsSubscribe_sureSubscribeBtn:
                //取消订阅或重新订阅
                changeSubscribe();
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getActivityView() {
        return mSureSubscribeBtn;
    }
}
