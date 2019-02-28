package com.zpjr.cunguan.presenter.impl.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.action.action.login.IForgetPwdFirstAction;
import com.zpjr.cunguan.action.action.login.IForgetPwdSecondAction;
import com.zpjr.cunguan.action.impl.login.ForgetPwdFirstActionImpl;
import com.zpjr.cunguan.action.impl.login.ForgetPwdSecondActionImpl;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.entity.module.ApiResponseModule;
import com.zpjr.cunguan.presenter.presenter.login.IForgetPwdSecondPresenter;
import com.zpjr.cunguan.receiver.SmsCodeObserver;
import com.zpjr.cunguan.ui.activity.login.ForgetPwdSecondActivity;
import com.zpjr.cunguan.ui.activity.login.RegisterFirstActivity;
import com.zpjr.cunguan.view.login.IForgetPwdFirstView;
import com.zpjr.cunguan.view.login.IForgetPwdSecondView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:      忘记密码第二步-presenter逻辑处理
 * Autour：          LF
 * Date：            2017/8/1 17:02
 */

public class ForgetPwdSecondPresenterImpl  extends BasePresenterImpl implements IForgetPwdSecondPresenter, PresenterCallBack {

    private IForgetPwdSecondView mView;
    private IForgetPwdSecondAction mAction;

    private String mPhoneNumber;
    private String mCodeNumber;
    private String mNewPwd;
    private String mCommitPwd;

    public ForgetPwdSecondPresenterImpl(IForgetPwdSecondView view) {
        this.mView = view;
        this.mAction = new ForgetPwdSecondActionImpl();
    }

    @Override
    public boolean checkLegal() {
        //隐藏输入法
        mView.getInputManager().hideSoftInputFromWindow(((ForgetPwdSecondActivity)mView.getContext()).getCurrentFocus().getWindowToken(),0);
        Intent intent = ((ForgetPwdSecondActivity)mView.getContext()).getIntent();
        if (intent == null) {
            return false;
        }
        //            mode = intent.getIntExtra("mode", 1);
        mPhoneNumber = intent.getStringExtra("mobile");
        mCodeNumber = intent.getStringExtra("code");
        mNewPwd = mView.getNewPwdClet().getText().toString().trim();
        mCommitPwd = mView.getCommitPwdClet().getText().toString().trim();

        if (TextUtils.isEmpty(mNewPwd)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(),mView.getContext().getString(R.string.regesiter_user_hintpwd),SnackbarUtil.INFO).show();
            mView.getNewPwdClet().requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(mCommitPwd)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(),mView.getContext().getString(R.string.regesiter_user_hintcommitpwd),SnackbarUtil.INFO).show();
            mView.getCommitPwdClet().requestFocus();
            return false;
        }
        if (!mNewPwd.equals(mCommitPwd)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(),"两次密码输入不同",SnackbarUtil.INFO).show();
            mView.getNewPwdClet().requestFocus();
            mView.getCommitPwdClet().requestFocus();
            return false;
        }else if(mNewPwd.length()<6 || mNewPwd.length()>16){
            SnackbarUtil.ShortSnackbar(mView.getActivityView(),mView.getContext().getString(R.string.register_hint_pwd),SnackbarUtil.INFO).show();
            mView.getNewPwdClet().requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void commitPwd() {
        if(checkLegal()){
            Map<String, String> parameter = new HashMap<>();
            parameter.put("mobile", mPhoneNumber);
            parameter.put("captcha", mCodeNumber);
            parameter.put("newPassword", mNewPwd);
            parameter.put("rePass", mCommitPwd);
            parameter.put("smsType", "CONFIRM_CREDITMARKET_CHANGE_LOGIN_PASSWORD");
            mAction.updatePwd(parameter,this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forgetPwdSecond_submitBtn:
                commitPwd();
                break;
        }
    }

    @Override
    public void onSuccess(Object result) {
        ApiResponseModule module = (ApiResponseModule) JSON.parseObject(result.toString(), ApiResponseModule.class);
        if (module.isSuccess()) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "修改成功", SnackbarUtil.INFO).show();
            ((ForgetPwdSecondActivity)mView.getContext()).finish();
        } else {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), module.getErrorMessage(), SnackbarUtil.INFO).show();
        }
    }

    @Override
    public void onFail(String errMsg) {
        SnackbarUtil.ShortSnackbar(mView.getActivityView(), "修改失败", SnackbarUtil.INFO).show();
    }
}
