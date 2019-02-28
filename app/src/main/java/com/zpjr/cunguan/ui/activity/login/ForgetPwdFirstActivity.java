package com.zpjr.cunguan.ui.activity.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.common.views.ClearEditText;
import com.zpjr.cunguan.presenter.impl.login.ForgetPwdFirstPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.login.IForgetPwdFirstPresenter;
import com.zpjr.cunguan.view.login.IForgetPwdFirstView;

/**
 * Description:      忘记密码-第一步
 * Autour：          LF   
 * Date：            2017/7/28 10:31
 */ 
public class ForgetPwdFirstActivity extends BaseActivity implements IForgetPwdFirstView, View.OnClickListener {

    private ClearEditText mPhoneClet;
    private ClearEditText mSmsCodeClet;
    private Button mGetCodeBtn;
    private Button mNextBtn;

    private IForgetPwdFirstPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarTitle("修改登录密码");
        setContentView(R.layout.activity_forget_pwd_first);
        mPresenter=new ForgetPwdFirstPresenterImpl(this);
        initView();
        initListener();
    }

    @Override
    public void initView() {
        mPhoneClet= (ClearEditText) findViewById(R.id.forgetPwdForst_phoneClet);
        mSmsCodeClet= (ClearEditText) findViewById(R.id.forgetPwdForst_smsCodeClet);
        mGetCodeBtn= (Button) findViewById(R.id.forgetPwdForst_getCodeBtn);
        mNextBtn= (Button) findViewById(R.id.forgetPwdForst_nextBtn);
    }

    @Override
    public void initListener() {
        mGetCodeBtn.setOnClickListener(this);
        mNextBtn.setOnClickListener(this);
    }

    @Override
    public ClearEditText getPhoneClet() {
        return mPhoneClet;
    }

    @Override
    public ClearEditText getSmsCodeClet() {
        return mSmsCodeClet;
    }

    @Override
    public Button getCodeBtn() {
        return mGetCodeBtn;
    }

    @Override
    public InputMethodManager getInputManager() {
        return mImm;
    }

    @Override
    public void onClick(View view) {
        mPresenter.onClick(view);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getActivityView() {
        return mNextBtn;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destoryObserver();
    }
}
