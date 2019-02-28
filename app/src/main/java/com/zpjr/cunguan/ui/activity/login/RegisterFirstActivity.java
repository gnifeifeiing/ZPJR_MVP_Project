package com.zpjr.cunguan.ui.activity.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.common.views.ClearEditText;
import com.zpjr.cunguan.presenter.impl.login.RegisterFirstPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.login.IRegisterFirstPresenter;
import com.zpjr.cunguan.view.login.IRegisterFirstView;

/**
 * Description:      注册第一步
 * Autour：          LF   
 * Date：            2017/8/2 10:12
 */ 
public class RegisterFirstActivity extends BaseActivity implements IRegisterFirstView, View.OnClickListener {

    private ClearEditText mPhoneClet;
    private Button mNextBtn;

    private IRegisterFirstPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarTitle("手机号验证");
        setContentView(R.layout.activity_register_first);
        mPresenter=new RegisterFirstPresenterImpl(this);
        initView();
        initListener();
    }

    @Override
    public void initView() {
        mPhoneClet= (ClearEditText) findViewById(R.id.registerFirst_phoneClet);
        mNextBtn= (Button) findViewById(R.id.registerFirst_nextBtn);
    }

    @Override
    public void initListener() {
        mNextBtn.setOnClickListener(this);
    }

    @Override
    public ClearEditText getPhoneClet() {
        return mPhoneClet;
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

}
