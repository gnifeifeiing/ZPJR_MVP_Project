package com.zpjr.cunguan.ui.activity.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.common.utils.Constants;
import com.zpjr.cunguan.common.views.ClearEditText;
import com.zpjr.cunguan.presenter.impl.login.LoginPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.login.ILoginPresenter;
import com.zpjr.cunguan.view.login.IloginView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:      登录页
 * Autour：          LF
 * Date：            2017/7/28 10:08
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener, IloginView, View.OnFocusChangeListener {

    private ImageView mBackIv;

    private Button mSubmitBtn;

    private TextView mTitleTv;
    private TextView mGoRegisterTv;
    private TextView mFogetPwdTv;

    private ImageView mHeaderIv;

    private ClearEditText mNameClet;
    private ClearEditText mPwdClet;

    private ILoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBar();
        setContentView(R.layout.activity_login);
        mPresenter = new LoginPresenterImpl(this);
        initView();
        initListener();
    }

    @Override
    public void initView() {
        mBackIv = (ImageView) findViewById(R.id.login_backIv);
        mHeaderIv = (ImageView) findViewById(R.id.login_headerIv);

        mSubmitBtn = (Button) findViewById(R.id.login_submitBtn);

        mTitleTv = (TextView) findViewById(R.id.login_titleTv);
        mGoRegisterTv = (TextView) findViewById(R.id.login_goRegisterTv);
        mFogetPwdTv = (TextView) findViewById(R.id.login_forgetPwdTv);

        mNameClet = (ClearEditText) findViewById(R.id.login_nameClet);
        mPwdClet = (ClearEditText) findViewById(R.id.login_pwdClet);
    }


    @Override
    public void initListener() {
        mBackIv.setOnClickListener(this);
        mSubmitBtn.setOnClickListener(this);
        mGoRegisterTv.setOnClickListener(this);
        mFogetPwdTv.setOnClickListener(this);

        mNameClet.setOnFocusChangeListener(this);
        mPwdClet.setOnFocusChangeListener(this);
    }

    @Override
    public ClearEditText getNameClet() {
        return mNameClet;
    }

    @Override
    public ClearEditText getPwdClet() {
        return mPwdClet;
    }

    @Override
    public TextView getTitleTv() {
        return mTitleTv;
    }

    @Override
    public ImageView getHeaderImageIv() {
        return mHeaderIv;
    }

    @Override
    public Map<String, String> getLoginParameter() {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", Constants.CLIENT_ID);
        params.put("client_secret", Constants.CLIENT_SECRET);
        params.put("grant_type", Constants.GRANT_TYPE);
        params.put("username", mNameClet.getText().toString().trim());
        params.put("password", mPwdClet.getText().toString().trim());
        params.put("equipmentType", android.os.Build.MODEL);
        params.put("source", "MOBILE");
        return params;
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
        return mBackIv;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        mPresenter.onClearEditTextFocusChange(view, b);
    }
}
