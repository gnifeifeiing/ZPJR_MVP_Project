package com.zpjr.cunguan.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zpjr.cunguan.MyApplication;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseFragment;
import com.zpjr.cunguan.presenter.impl.fragment.SettingFragmentPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.fragment.ISettingFragmentPresenter;
import com.zpjr.cunguan.view.fragment.ISettingFragmentView;

/**
 * Description:      设置
 * Autour：          LF
 * Date：            2017/7/10 16:03
 */

public class SettingFragment extends BaseFragment implements ISettingFragmentView, View.OnClickListener {

    public LinearLayout mHadLoginLl;
    public TextView mUserNameTv;

    public LinearLayout mMessageCenterLl;

    public LinearLayout mTruthNameLl;
    public TextView mHadApproveTv;
    public ImageView mOpenDepositIv;

    public LinearLayout mMyBankCardLl;
    public TextView mHadBindingTv;

    public LinearLayout mLoginPasswordLl;
    public TextView mChangePasswordTv;

    public LinearLayout mBankPhonenumberLl;
    public TextView mChangeBankPhonenumberTv;

    public LinearLayout mGesturePasswordLl;
    public TextView mChangeGestureTv;

    public LinearLayout mSmsSubscribeLl;
    public TextView mChangeSmsSubscribeTv;

    public LinearLayout mAboutUsLl;

    public LinearLayout mHelpCenterLl;

    public LinearLayout mCallServersLl;
    public TextView mServerNumberTv;

    public LinearLayout mSoftVersionLl;
    public TextView mApkVersionTv;

    public Button mLogoutSettingBtn;


    private ISettingFragmentPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_setting, container, false);
        mPresenter=new SettingFragmentPresenterImpl(this);
        return mView;
    }

    @Override
    public void initListener() {
        mMessageCenterLl.setOnClickListener(this);
        mTruthNameLl.setOnClickListener(this);
        mMyBankCardLl.setOnClickListener(this);
        mLoginPasswordLl.setOnClickListener(this);
        mBankPhonenumberLl.setOnClickListener(this);
        mGesturePasswordLl.setOnClickListener(this);
        mAboutUsLl.setOnClickListener(this);
        mHelpCenterLl.setOnClickListener(this);
        mCallServersLl.setOnClickListener(this);
        mSoftVersionLl.setOnClickListener(this);
        mLogoutSettingBtn.setOnClickListener(this);
        mSmsSubscribeLl.setOnClickListener(this);
    }

    @Override
    public void initView() {
        mHadLoginLl=mView.findViewById(R.id.setting_hadLoginLl);
        mUserNameTv=mView.findViewById(R.id.setting_userNameTv);

        mMessageCenterLl=mView.findViewById(R.id.setting_messageCenterLl);

        mTruthNameLl=mView.findViewById(R.id.setting_truthNameLl);
        mHadApproveTv=mView.findViewById(R.id.setting_hadApproveTv);
        mOpenDepositIv=mView.findViewById(R.id.setting_openDepositIv);

        mMyBankCardLl=mView.findViewById(R.id.setting_myBankCardLl);
        mHadBindingTv=mView.findViewById(R.id.setting_hadBindingTv);

        mLoginPasswordLl=mView.findViewById(R.id.setting_loginPasswordLl);
        mChangePasswordTv=mView.findViewById(R.id.setting_changePasswordTv);

        mBankPhonenumberLl=mView.findViewById(R.id.setting_bankPhonenumberLl);
        mChangeBankPhonenumberTv=mView.findViewById(R.id.setting_changeBankPhonenumberTv);

        mGesturePasswordLl=mView.findViewById(R.id.setting_gesturePasswordLl);
        mChangeGestureTv=mView.findViewById(R.id.setting_changeGestureTv);

        mSmsSubscribeLl=mView.findViewById(R.id.setting_smsSubscribeLl);
        mChangeSmsSubscribeTv=mView.findViewById(R.id.setting_changeSmsSubscribeTv);

        mAboutUsLl=mView.findViewById(R.id.setting_aboutUsLl);

        mHelpCenterLl=mView.findViewById(R.id.setting_helpCenterLl);

        mCallServersLl=mView.findViewById(R.id.setting_callServersLl);
        mServerNumberTv=mView.findViewById(R.id.setting_serverNumberTv);

        mSoftVersionLl=mView.findViewById(R.id.setting_softVersionLl);
        mApkVersionTv=mView.findViewById(R.id.setting_apkVersionTv);

        mLogoutSettingBtn=mView.findViewById(R.id.setting_logoutSettingBtn);
    }

    @Override
    public void initData() {
        //获取并设置app版本信息
        mPresenter.getVersionInfo();
    }

    @Override
    public void onResume() {
        super.onResume();
        //检查登录状态并进行相应的逻辑判断
        mPresenter.checkLoginstate();
    }

    @Override
    public View getActivityView() {
        return mLogoutSettingBtn;
    }

    @Override
    public Context getContext() {
        return getActivity();
    }


    public LinearLayout getmHadLoginLl() {
        return mHadLoginLl;
    }

    public TextView getmUserNameTv() {
        return mUserNameTv;
    }

    public LinearLayout getmMessageCenterLl() {
        return mMessageCenterLl;
    }

    public LinearLayout getmTruthNameLl() {
        return mTruthNameLl;
    }

    public TextView getmHadApproveTv() {
        return mHadApproveTv;
    }

    public ImageView getmOpenDepositIv() {
        return mOpenDepositIv;
    }

    public LinearLayout getmMyBankCardLl() {
        return mMyBankCardLl;
    }

    public TextView getmHadBindingTv() {
        return mHadBindingTv;
    }

    public LinearLayout getmLoginPasswordLl() {
        return mLoginPasswordLl;
    }

    public TextView getmChangePasswordTv() {
        return mChangePasswordTv;
    }

    public LinearLayout getmBankPhonenumberLl() {
        return mBankPhonenumberLl;
    }

    public TextView getmChangeBankPhonenumberTv() {
        return mChangeBankPhonenumberTv;
    }

    public LinearLayout getmGesturePasswordLl() {
        return mGesturePasswordLl;
    }

    public TextView getmChangeGestureTv() {
        return mChangeGestureTv;
    }

    public LinearLayout getmSmsSubscribeLl() {
        return mSmsSubscribeLl;
    }

    public TextView getmChangeSmsSubscribeTv() {
        return mChangeSmsSubscribeTv;
    }

    public LinearLayout getmAboutUsLl() {
        return mAboutUsLl;
    }

    public LinearLayout getmHelpCenterLl() {
        return mHelpCenterLl;
    }

    public LinearLayout getmCallServersLl() {
        return mCallServersLl;
    }

    public TextView getmServerNumberTv() {
        return mServerNumberTv;
    }

    public LinearLayout getmSoftVersionLl() {
        return mSoftVersionLl;
    }

    public TextView getmApkVersionTv() {
        return mApkVersionTv;
    }

    public Button getmLogoutSettingBtn() {
        return mLogoutSettingBtn;
    }

    @Override
    public void onClick(View view) {
        mPresenter.onClick(view);
    }
}
