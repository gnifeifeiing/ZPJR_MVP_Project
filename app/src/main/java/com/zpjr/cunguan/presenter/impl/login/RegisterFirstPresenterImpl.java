package com.zpjr.cunguan.presenter.impl.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.action.action.login.IForgetPwdFirstAction;
import com.zpjr.cunguan.action.impl.login.ForgetPwdFirstActionImpl;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.common.utils.StringUtils;
import com.zpjr.cunguan.entity.module.ApiResponseModule;
import com.zpjr.cunguan.presenter.presenter.login.IRegisterFirstPresenter;
import com.zpjr.cunguan.ui.activity.login.RegisterFirstActivity;
import com.zpjr.cunguan.ui.activity.login.RegisterSecondActivity;
import com.zpjr.cunguan.view.login.IRegisterFirstView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:      注册第一步-presenter逻辑处理
 * Autour：          LF
 * Date：            2017/8/2 10:25
 */

public class RegisterFirstPresenterImpl extends BasePresenterImpl implements IRegisterFirstPresenter, PresenterCallBack {

    private IRegisterFirstView mView;
    private IForgetPwdFirstAction mAction;

    private String mPhoneNumber;

    public RegisterFirstPresenterImpl(IRegisterFirstView view) {
        this.mView = view;
        this.mAction = new ForgetPwdFirstActionImpl();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registerFirst_nextBtn:
                checkPhoneIsRegister();
                break;
        }
    }

    @Override
    public boolean checkNull() {
        //隐藏输入法
        mView.getInputManager().hideSoftInputFromWindow(((RegisterFirstActivity)mView.getContext()).getCurrentFocus().getWindowToken(),0);
        mPhoneNumber = mView.getPhoneClet().getText().toString().trim();
        if (TextUtils.isEmpty(mPhoneNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(),mView.getContext().getString(R.string.login_user_hintname),SnackbarUtil.INFO).show();
            mView.getPhoneClet().requestFocus();
            return false;
        }
        if (!StringUtils.isMobileNO(mPhoneNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(),mView.getContext().getString(R.string.regesiter_phonewrongtype),SnackbarUtil.INFO).show();
            mView.getPhoneClet().requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void checkPhoneIsRegister() {
        if (checkNull()) {
            Map<String, String> parameter = new HashMap<>();
            parameter.put("mobile", mPhoneNumber);
            mAction.checkPhoneRegistered(parameter,this);
        }
    }

    @Override
    public void onSuccess(Object result) {
        ApiResponseModule module = (ApiResponseModule) JSON.parseObject(result.toString(), ApiResponseModule.class);
        if (module.isSuccess()) {
            //下一步
            Intent intent=new Intent(mView.getContext(), RegisterSecondActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("phone",mPhoneNumber);
            intent.putExtras(bundle);
            mView.getContext().startActivity(intent);
        } else {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "手机号已经被注册", SnackbarUtil.INFO).show();
        }
    }

    @Override
    public void onFail(String errMsg) {
        SnackbarUtil.ShortSnackbar(mView.getActivityView(), "手机号验证失败", SnackbarUtil.INFO).show();
    }
}
