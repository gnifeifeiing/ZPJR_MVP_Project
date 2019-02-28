package com.zpjr.cunguan.ui.activity.setting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.presenter.impl.setting.UpdateBankMobilePresenterImpl;
import com.zpjr.cunguan.presenter.presenter.setting.IUpdateBankMobilePresenter;
import com.zpjr.cunguan.view.setting.IUpdateBankMobileView;

/**
 * Description:      修改银行预留手机号
 * Autour：          LF
 * Date：            2017/8/29 10:22
 */
public class UpdateBankMobileActivity extends BaseActivity implements View.OnClickListener,IUpdateBankMobileView {

    private EditText mOldPhoneEt;
    private EditText mNewPhoneEt;
    private LinearLayout mDynamicNumberLl;
    private EditText mDynamicNumberEt;
    private TextView mDynamicNumberTv;
    private TextView mSendMessageTv;
    private Button mCommitBtn;
    private String mBindSerialNo;

    private IUpdateBankMobilePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarTitle("更换银行预留手机号");
        setContentView(R.layout.activity_update_bank_mobile);
        mBindSerialNo = getIntent().getStringExtra("bindSerialNo");
        mPresenter=new UpdateBankMobilePresenterImpl(this,mBindSerialNo);
        initView();
        initListener();
    }

    private void initListener() {
        mDynamicNumberTv.setOnClickListener(this);
        mCommitBtn.setOnClickListener(this);
    }

    private void initView() {
        mOldPhoneEt= (EditText) findViewById(R.id.updateBankMobile_oldPhoneEt);
        mNewPhoneEt= (EditText) findViewById(R.id.updateBankMobile_newPhoneEt);
        mDynamicNumberLl= (LinearLayout) findViewById(R.id.updateBankMobile_dynamicNumberLl);
        mDynamicNumberEt= (EditText) findViewById(R.id.updateBankMobile_dynamicNumberEt);
        mDynamicNumberTv= (TextView) findViewById(R.id.updateBankMobile_dynamicNumberTv);
        mSendMessageTv= (TextView) findViewById(R.id.updateBankMobile_sendMessageTv);
        mCommitBtn= (Button) findViewById(R.id.updateBankMobile_commitBtn);
    }

    @Override
    public void onClick(View view) {
        mPresenter.onClick(view);
    }

    public TextView getmSendMessageTv() {
        return mSendMessageTv;
    }

    public EditText getmOldPhoneEt() {
        return mOldPhoneEt;
    }

    public EditText getmNewPhoneEt() {
        return mNewPhoneEt;
    }

    public LinearLayout getmDynamicNumberLl() {
        return mDynamicNumberLl;
    }

    public EditText getmDynamicNumberEt() {
        return mDynamicNumberEt;
    }

    public TextView getmDynamicNumberTv() {
        return mDynamicNumberTv;
    }

    public Button getmCommitBtn() {
        return mCommitBtn;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getActivityView() {
        return mCommitBtn;
    }
}
