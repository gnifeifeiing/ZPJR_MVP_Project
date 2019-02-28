package com.zpjr.cunguan.ui.activity.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.common.views.ClearEditText;
import com.zpjr.cunguan.common.views.TextImageButton;
import com.zpjr.cunguan.presenter.impl.login.RegisterSecondPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.login.IRegisterSecondPresenter;
import com.zpjr.cunguan.view.login.IRegisterSecondView;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * Description:      注册第二步
 * Autour：          LF
 * Date：            2017/8/2 15:29
 */
public class RegisterSecondActivity extends BaseActivity implements IRegisterSecondView, OnClickListener {

    private ClearEditText mImageCodeClet;
    private ClearEditText mCodeClet;
    private ClearEditText mPwdClet;
    private ClearEditText mReferralPhoneClet;

    private TextImageButton mTibCodeTvImgBtn;
    private Button mGetCodeBtn;
    private Button mRegisterBtn;

    private CheckBox mAgreeCb;
    private TextView mAgreeTv;
    private TextView mSendMessageTv;

    private IRegisterSecondPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarTitle("手机号验证");
        setContentView(R.layout.activity_register_second);
        mPresenter = new RegisterSecondPresenterImpl(this);
        initView();
        initListener();
        getImgCode();
    }

    @Override
    public void initView() {
        mImageCodeClet = (ClearEditText) findViewById(R.id.registerSecond_imageCodeClet);
        mCodeClet = (ClearEditText) findViewById(R.id.registerSecond_codeClet);
        mPwdClet = (ClearEditText) findViewById(R.id.registerSecond_pwdClet);
        mReferralPhoneClet = (ClearEditText) findViewById(R.id.registerSecond_referralPhoneClet);

        mTibCodeTvImgBtn = (TextImageButton) findViewById(R.id.registerSecond_tibCodeTvImgBtn);
        mGetCodeBtn = (Button) findViewById(R.id.registerSecond_getCodeBtn);
        mRegisterBtn = (Button) findViewById(R.id.registerSecond_registerBtn);

        mAgreeCb = (CheckBox) findViewById(R.id.registerSecond_agreeCb);
        mAgreeTv = (TextView) findViewById(R.id.registerSecond_agreeTv);
        mSendMessageTv = (TextView) findViewById(R.id.registerSecond_sendMessageTv);
    }

    @Override
    public void initListener() {
        mTibCodeTvImgBtn.setOnClickListener(this);
        mGetCodeBtn.setOnClickListener(this);
        mRegisterBtn.setOnClickListener(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getActivityView() {
        return mRegisterBtn;
    }

    @Override
    public void onClick(View view) {
        mPresenter.onClick(view);
    }

    @Override
    public void getImgCode() {
        mPresenter.getImgCode();
    }

    @Override
    public TextImageButton getTibCodeTvImgBtn() {
        return mTibCodeTvImgBtn;
    }

    @Override
    public ClearEditText getImageCodeClet() {
        return mImageCodeClet;
    }

    @Override
    public ClearEditText getCodeClet() {
        return mCodeClet;
    }

    @Override
    public ClearEditText getPwdClet() {
        return mPwdClet;
    }

    @Override
    public ClearEditText getReferralPhoneClet() {
        return mReferralPhoneClet;
    }

    @Override
    public CheckBox getAgreeCb() {
        return mAgreeCb;
    }

    @Override
    public Button getCodeBtn() {
        return mGetCodeBtn;
    }

    @Override
    public TextView getSendMessageTv() {
        return mSendMessageTv;
    }
}

