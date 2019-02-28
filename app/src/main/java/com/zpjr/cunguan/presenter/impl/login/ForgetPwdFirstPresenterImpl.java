package com.zpjr.cunguan.presenter.impl.login;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.action.action.login.IForgetPwdFirstAction;
import com.zpjr.cunguan.action.action.login.ILoginAction;
import com.zpjr.cunguan.action.impl.login.ForgetPwdFirstActionImpl;
import com.zpjr.cunguan.action.impl.login.LoginActionImpl;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.common.utils.StringUtils;
import com.zpjr.cunguan.entity.module.ApiResponseModule;
import com.zpjr.cunguan.entity.module.LoginModule;
import com.zpjr.cunguan.presenter.presenter.login.IForgetPwdFirstPresenter;
import com.zpjr.cunguan.receiver.SmsCodeObserver;
import com.zpjr.cunguan.ui.activity.login.ForgetPwdFirstActivity;
import com.zpjr.cunguan.ui.activity.login.ForgetPwdSecondActivity;
import com.zpjr.cunguan.ui.activity.login.RegisterFirstActivity;
import com.zpjr.cunguan.view.login.IForgetPwdFirstView;
import com.zpjr.cunguan.view.login.IloginView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:      忘记密码第一步-presenter逻辑处理
 * Autour：          LF
 * Date：            2017/8/1 10:15
 */

public class ForgetPwdFirstPresenterImpl  extends BasePresenterImpl implements IForgetPwdFirstPresenter {

    private IForgetPwdFirstView mView;
    private IForgetPwdFirstAction mAction;

    private String mPhoneNumber;
    private String mCodeNumber;

    private SmsCodeObserver mSmsCodeObserver;

    public ForgetPwdFirstPresenterImpl(IForgetPwdFirstView view) {
        this.mView = view;
        this.mAction = new ForgetPwdFirstActionImpl();
    }

    public Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0) {
                String code = (String) msg.obj;
                mView.getSmsCodeClet().setText(code);
            }
        }

        ;
    };

    @Override
    public void checkNullAndSendSms() {
        //隐藏输入法
        mView.getInputManager().hideSoftInputFromWindow(((ForgetPwdFirstActivity)mView.getContext()).getCurrentFocus().getWindowToken(),0);
        mPhoneNumber = mView.getPhoneClet().getText().toString().trim();
        if (TextUtils.isEmpty(mPhoneNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入手机号码", SnackbarUtil.INFO).show();
            mView.getPhoneClet().requestFocus();
        } else {
            if (StringUtils.isMobileNO(mPhoneNumber)) {
                //判断手机号是否注册
                checkPhoneRegistered(mPhoneNumber);
            } else {
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入正确的手机号码", SnackbarUtil.INFO).show();
                mView.getPhoneClet().requestFocus();
            }

        }
    }

    @Override
    public void checkPhoneRegistered(String phoneNumber) {
        final Map<String, String> parameter = new HashMap<>();
        parameter.put("mobile", phoneNumber);
        mAction.checkPhoneRegistered(parameter, new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                ApiResponseModule module = (ApiResponseModule) JSON.parseObject(result.toString(), ApiResponseModule.class);
                if (module.isSuccess()) {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "手机号尚未注册", SnackbarUtil.INFO).show();
                } else {
                    getSmsCode(parameter);
                }
            }

            @Override
            public void onFail(String errMsg) {
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), "手机号验证失败", SnackbarUtil.INFO).show();
            }
        });
    }

    @Override
    public void getSmsCode(Map<String, String> parameter) {
        mAction.getSmsCode(parameter, new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                ApiResponseModule module = (ApiResponseModule) JSON.parseObject(result.toString(), ApiResponseModule.class);
                if (module.isSuccess()) {
                    // 验证码长度为6
//                    mSmsCodeObserver = new SmsCodeObserver(mView.getContext(), mHandler, 6);
//                    Uri uri = Uri.parse("content://sms");
//                    mView.getContext().getContentResolver().registerContentObserver(uri, true, mSmsCodeObserver);
                } else {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), module.getErrorMessage(), SnackbarUtil.INFO).show();
                }
            }

            @Override
            public void onFail(String errMsg) {
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), "手机号验证失败", SnackbarUtil.INFO).show();
            }
        });
        new CountDownTask().execute();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forgetPwdForst_getCodeBtn:
                checkNullAndSendSms();
                break;
            case R.id.forgetPwdForst_nextBtn:
                checkCode();
                break;
        }
    }

    @Override
    public boolean nextCheckNull() {
        //隐藏输入法
        mView.getInputManager().hideSoftInputFromWindow(((ForgetPwdFirstActivity)mView.getContext()).getCurrentFocus().getWindowToken(),0);
        mPhoneNumber = mView.getPhoneClet().getText().toString().trim();
        mCodeNumber = mView.getSmsCodeClet().getText().toString().trim();
        if (TextUtils.isEmpty(mPhoneNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), mView.getContext().getString(R.string.login_user_hintname), SnackbarUtil.INFO).show();
            mView.getPhoneClet().requestFocus();
            return false;
        } else if (!StringUtils.isMobileNO(mPhoneNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), mView.getContext().getString(R.string.regesiter_phonewrongtype), SnackbarUtil.INFO).show();
            mView.getPhoneClet().requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(mCodeNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), mView.getContext().getString(R.string.login_user_hintcode), SnackbarUtil.INFO).show();
            mView.getSmsCodeClet().requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void checkCode() {
        if (nextCheckNull()) {
            Map<String, String> parameter = new HashMap<>();
            parameter.put("mobile", mPhoneNumber);
            parameter.put("captcha", mCodeNumber);
            parameter.put("smsType", "CONFIRM_CREDITMARKET_CHANGE_LOGIN_PASSWORD");
            mAction.checkCode(parameter, new PresenterCallBack() {
                @Override
                public void onSuccess(Object result) {
                    ApiResponseModule module = (ApiResponseModule) JSON.parseObject(result.toString(), ApiResponseModule.class);
                    if (module.isSuccess()) {
                        Intent intent = new Intent(mView.getContext(), ForgetPwdSecondActivity.class);
                        intent.putExtra("mobile", mPhoneNumber);
                        intent.putExtra("code", mCodeNumber);
                        mView.getContext().startActivity(intent);
                        ((ForgetPwdFirstActivity) mView.getContext()).finish();
                    } else {
                        SnackbarUtil.ShortSnackbar(mView.getActivityView(), module.getErrorMessage(), SnackbarUtil.INFO).show();
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "验证失败", SnackbarUtil.INFO).show();
                }
            });
        }
    }

    @Override
    public void destoryObserver() {
        if (mSmsCodeObserver != null) {
            mView.getContext().getContentResolver().unregisterContentObserver(mSmsCodeObserver);
        }
    }

    /**
     * 验证码计时
     */
    public class CountDownTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            Log.e("TASk", "preexecute");
            mView.getCodeBtn().setEnabled(false);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void result) {
            mView.getCodeBtn().setEnabled(true);
            mView.getCodeBtn().setText(mView.getContext()
                    .getString(R.string.regesiter_getcode));
            Log.e("TASk", "postexecute");
            super.onPostExecute(result);
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.e("TASk", "doinbackground");
            for (int i = 60; i >= 0; i--) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.e("TASk", "onprogressupdate");
            mView.getCodeBtn().setText("重新发送(" + values[0] + ")");
            super.onProgressUpdate(values);
        }
    }
}
