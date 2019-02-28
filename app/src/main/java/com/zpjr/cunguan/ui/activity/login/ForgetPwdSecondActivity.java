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
import com.zpjr.cunguan.presenter.impl.login.ForgetPwdSecondPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.login.IForgetPwdSecondPresenter;
import com.zpjr.cunguan.view.login.IForgetPwdSecondView;

/**
 * Description:      忘记密码-第二步
 * Autour：          LF   
 * Date：            2017/8/1 15:40
 */ 
public class ForgetPwdSecondActivity extends BaseActivity implements IForgetPwdSecondView, View.OnClickListener {

    private ClearEditText mNewPwdClet;
    private ClearEditText mCommitPwdClet;
    private Button mSubmitBtn;

    private IForgetPwdSecondPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarTitle("新密码设置");
        setContentView(R.layout.activity_forget_pwd_second);
        mPresenter=new ForgetPwdSecondPresenterImpl(this);
        initView();
        initListener();
    }

    @Override
    public void initView() {
        mNewPwdClet= (ClearEditText) findViewById(R.id.forgetPwdSecond_newPwdClet);
        mCommitPwdClet= (ClearEditText) findViewById(R.id.forgetPwdSecond_commitPwdClet);
        mSubmitBtn= (Button) findViewById(R.id.forgetPwdSecond_submitBtn);
    }

    @Override
    public void initListener() {
        mSubmitBtn.setOnClickListener(this);
    }

    @Override
    public ClearEditText getNewPwdClet() {
        return mNewPwdClet;
    }

    @Override
    public ClearEditText getCommitPwdClet() {
        return mCommitPwdClet;
    }

    @Override
    public Button getSubmitBtn() {
        return mSubmitBtn;
    }

    @Override
    public InputMethodManager getInputManager() {
        return mImm;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getActivityView() {
        return mSubmitBtn;
    }

    @Override
    public void onClick(View view) {
        mPresenter.onClick(view);
    }
}
