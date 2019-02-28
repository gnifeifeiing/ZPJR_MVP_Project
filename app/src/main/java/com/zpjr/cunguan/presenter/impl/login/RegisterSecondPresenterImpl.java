package com.zpjr.cunguan.presenter.impl.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.action.action.login.IForgetPwdFirstAction;
import com.zpjr.cunguan.action.action.login.ILoginAction;
import com.zpjr.cunguan.action.action.login.IRegisterSecondAction;
import com.zpjr.cunguan.action.impl.login.ForgetPwdFirstActionImpl;
import com.zpjr.cunguan.action.impl.login.LoginActionImpl;
import com.zpjr.cunguan.action.impl.login.RegisterSecondActionImpl;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.cache.SharedPreferenceCache;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.Constants;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.entity.module.ApiResponseModule;
import com.zpjr.cunguan.entity.module.ImageCodeResponseModule;
import com.zpjr.cunguan.entity.module.LoginModule;
import com.zpjr.cunguan.entity.module.RegisterResponseModule;
import com.zpjr.cunguan.presenter.presenter.login.IRegisterSecondPresenter;
import com.zpjr.cunguan.ui.activity.login.RegisterSecondActivity;
import com.zpjr.cunguan.ui.activity.security.GestureLockSettingActivity;
import com.zpjr.cunguan.view.login.IRegisterFirstView;
import com.zpjr.cunguan.view.login.IRegisterSecondView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:      注册第二步-presenter逻辑处理
 * Autour：          LF
 * Date：            2017/8/2 16:13
 */

public class RegisterSecondPresenterImpl extends BasePresenterImpl implements IRegisterSecondPresenter {

    private IRegisterSecondView mView;
    private ILoginAction mLoginAction;
    private IRegisterSecondAction mRegisterSecondAcion;

    private CountDownTask mTask;
    private String mImgToken;//图形码token
    private String mImgCode;//图形码
    private String mPhoneNumber;//注册手机号
    private String mCode;//验证码
    private String mPwd;//注册密码
    private String mReferralPhone;//推荐人手机号

    public RegisterSecondPresenterImpl(IRegisterSecondView view) {
        this.mView = view;
        this.mLoginAction = new LoginActionImpl();
        this.mRegisterSecondAcion = new RegisterSecondActionImpl();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //图形码
            case R.id.registerSecond_tibCodeTvImgBtn:
                getImgCode();
                break;
            //验证码
            case R.id.registerSecond_getCodeBtn:
                checkImgCodeIsRight();
                break;
            //提交
            case R.id.registerSecond_registerBtn:
                commitRegister();
                break;
        }
    }

    @Override
    public void getImgCode() {
        mRegisterSecondAcion.getImgCode(new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                ImageCodeResponseModule module = (ImageCodeResponseModule) JSON.parseObject(result.toString(), ImageCodeResponseModule.class);
                if (module == null)
                    return;
                if (TextUtils.isEmpty(module.getCaptcha()))
                    return;
                Bitmap bitmap;
                byte[] bitmapArray;
                bitmapArray = Base64.decode(module.getCaptcha().substring(module.getCaptcha().indexOf(",") + 1), Base64.DEFAULT);
                bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
                mView.getTibCodeTvImgBtn().setImageBitmap(bitmap);
                mView.getTibCodeTvImgBtn().setText("");
                mImgToken = module.getToken();
                Log.i("imgToken:", mImgToken);
            }

            @Override
            public void onFail(String errMsg) {
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), "获取图形码失败，请点击重试", SnackbarUtil.INFO).show();
                mView.getTibCodeTvImgBtn().setText("获取验证码");
                mView.getTibCodeTvImgBtn().setImageBitmap(null);
            }
        });
    }

    @Override
    public void checkImgCodeIsRight() {
        //显示加载框
        showLoadingDialog(mView.getContext(), "验证图形码");
        mImgCode = mView.getImageCodeClet().getText().toString().trim();
        if (TextUtils.isEmpty(mImgCode)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "图形码不能为空", SnackbarUtil.INFO).show();
            return;
        }
        Map<String, String> parameter = new HashMap<>();
        parameter.put("captcha", mImgCode);
        StringBuilder url = new StringBuilder(Constants.SERVER_URL);
        url.append("captcha?token=");
        url.append(mImgToken);

        mRegisterSecondAcion.checkImgCodeIsRight(url.toString(), parameter, new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                dismissLoadingDialog();

                ApiResponseModule module = (ApiResponseModule) JSON.parseObject(result.toString(), ApiResponseModule.class);
                if (module.isSuccess()) {
                    getRegisterCode();
                } else {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "图形验证码错误", SnackbarUtil.INFO).show();
                    mView.getImageCodeClet().setText("");
                    getImgCode();
                }

            }

            @Override
            public void onFail(String errMsg) {
                dismissLoadingDialog();
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), "验证图形码失败", SnackbarUtil.INFO).show();
                getImgCode();
            }
        });
    }

    @Override
    public void getRegisterCode() {
        //显示加载框
        showLoadingDialog(mView.getContext(), "获取验证码");

        mImgCode = mView.getImageCodeClet().getText().toString().trim();
        if (TextUtils.isEmpty(mImgCode)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入图形验证码", SnackbarUtil.INFO).show();
            mView.getImageCodeClet().requestFocus();
            return;
        }

        //获取要发送的手机号
        Bundle bundle = ((RegisterSecondActivity) mView.getContext()).getIntent().getExtras();
        if (bundle != null) {
            mPhoneNumber = bundle.get("phone").toString();
        } else {
            return;
        }

        //配置请求地址和请求参数
        Map<String, String> parameter = new HashMap<>();
        parameter.put("mobile", mPhoneNumber);
        parameter.put("captcha_token", mImgToken);
        parameter.put("captcha_answer", mImgCode);
        StringBuilder url = new StringBuilder(Constants.BASE_URL);
        url.append("register/ajax/smsCaptcha");

        mRegisterSecondAcion.getRegisterSmsCode(url.toString(), parameter, new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                dismissLoadingDialog();
                ApiResponseModule module = (ApiResponseModule) JSON.parseObject(result.toString(), ApiResponseModule.class);
                if (module.isSuccess()) {
                    mTask = new CountDownTask();
                    mTask.execute();
                    mView.getSendMessageTv().setVisibility(View.VISIBLE);
                    mView.getSendMessageTv().setText(String.format(mView.getContext().getString(
                            R.string.sendmessage), mPhoneNumber));
                } else {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), module.getErrorMessage(), SnackbarUtil.INFO).show();
                }
            }

            @Override
            public void onFail(String errMsg) {
                dismissLoadingDialog();
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), "获取验证码失败", SnackbarUtil.INFO).show();
            }
        });
    }

    @Override
    public void commitRegister() {
        //检测输入是否合法-为空
        if (checkFormInfo()) {
            showLoadingDialog(mView.getContext(), "注册中");
            //配置请求地址和请求参数
            Map<String, String> params = new HashMap<>();
            params.put("loginName", Constants.CLIENT_CODE + mPhoneNumber);
            params.put("mobile", mPhoneNumber);
            params.put("repassword", mPwd);
            params.put("password", mPwd);
            params.put("imgCaptcha", mImgCode);
            params.put("mobile_captcha", mCode);
            params.put("email", "");
            params.put("referral", mReferralPhone);
            params.put("agreement", "true");
            params.put("equipmentType", android.os.Build.MODEL);
            params.put("source", "MOBILE");
            mRegisterSecondAcion.commitRegister(params, new PresenterCallBack() {
                @Override
                public void onSuccess(Object result) {
                    RegisterResponseModule module = (RegisterResponseModule) JSON.parseObject(result.toString(), RegisterResponseModule.class);
                    if (module.isSuccess()) {
                        autoLogin();
                    } else {
                        if (module.getError() != null && module.getErrorMessage().equals("未知错误"))
                            SnackbarUtil.ShortSnackbar(mView.getActivityView(), module.getError().get(0).getMessage(), SnackbarUtil.INFO).show();
                        else
                            SnackbarUtil.ShortSnackbar(mView.getActivityView(), module.getErrorMessage(), SnackbarUtil.INFO).show();
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    dismissLoadingDialog();
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
                }
            });
        }
    }

    @Override
    public boolean checkFormInfo() {
        mImgCode = mView.getImageCodeClet().getText().toString().trim();
        mCode = mView.getCodeClet().getText().toString().trim();
        mPwd = mView.getPwdClet().getText().toString().trim();
        mReferralPhone = mView.getReferralPhoneClet().getText().toString().trim();

        if (TextUtils.isEmpty(mImgCode)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入图形验证码", SnackbarUtil.INFO).show();
            mView.getImageCodeClet().requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(mCode)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入短信验证码", SnackbarUtil.INFO).show();
            mView.getCodeClet().requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(mPwd)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入密码", SnackbarUtil.INFO).show();
            mView.getPwdClet().requestFocus();
            return false;
        }

        if (!mView.getAgreeCb().isChecked()) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请阅读并同意相关协议", SnackbarUtil.INFO).show();
            return false;
        } else if (mPwd.length() < 6 || mPwd.length() > 16) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), mView.getContext().getString(R.string.register_hint_pwd), SnackbarUtil.INFO).show();
            mView.getPwdClet().requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void autoLogin() {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", Constants.CLIENT_ID);
        params.put("client_secret", Constants.CLIENT_SECRET);
        params.put("grant_type", Constants.GRANT_TYPE);
        params.put("username", mPhoneNumber);
        params.put("password", mPwd);
        params.put("equipmentType", android.os.Build.MODEL);
        params.put("source", "MOBILE");
        mLoginAction.login(params, new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                dismissLoadingDialog();
                LoginModule module = (LoginModule) JSON.parseObject(result.toString(), LoginModule.class);
                if (module.getUser().enterprise) {
                } else {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "登录成功", SnackbarUtil.INFO).show();
                    saveUserInfo(module);
                }
                mView.getContext().startActivity(new Intent(mView.getContext(), GestureLockSettingActivity.class));
                ((RegisterSecondActivity)mView.getContext()).finish();
            }

            @Override
            public void onFail(String errMsg) {
                dismissLoadingDialog();
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
            }
        });
    }

    @Override
    public void saveUserInfo(LoginModule module) {
        SharedPreferenceCache.getInstance().putPres("IsLogin", "1");
        SharedPreferenceCache.getInstance().putPres("UserId", module.getUser().getId());
        SharedPreferenceCache.getInstance().putPres("UserName", module.getUser().getName());
        //真实姓名和身份证号都存在的情况下，则已经实名认证 但是登录接口返回的json数据中没有idNumber这个字段，所以身份证号码是空的
        SharedPreferenceCache.getInstance().putPres("CardNum", module.getUser().getIdNumber());
        SharedPreferenceCache.getInstance().putPres("LoginMobile", module.getUser().getMobile());
        SharedPreferenceCache.getInstance().putPres("AccessToken", module.getAccess_token());
        SharedPreferenceCache.getInstance().putPres("GroupId", module.getUser().getGroupId());
        SharedPreferenceCache.getInstance().putPres("Enterprise", String.valueOf(module.getUser().isEnterprise()));

        //是否开户
        SharedPreferenceCache.getInstance().putPres("KaiHu", "0");
    }

    /**
     * 验证码倒计时
     */
    public class CountDownTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            mView.getCodeBtn().setEnabled(false);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void result) {
            mView.getCodeBtn().setEnabled(true);
            mView.getCodeBtn().setText(mView.getContext().getString(R.string.regesiter_getcode));
            super.onPostExecute(result);
        }


        @Override
        protected Void doInBackground(Void... params) {
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
            mView.getCodeBtn().setText("重新发送(" + values[0] + ")");
            super.onProgressUpdate(values);
        }
    }
}
