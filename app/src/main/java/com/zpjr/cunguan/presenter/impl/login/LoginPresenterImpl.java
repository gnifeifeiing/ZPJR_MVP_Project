package com.zpjr.cunguan.presenter.impl.login;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zpjr.cunguan.MyApplication;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.action.action.investment.IInvestmentAction;
import com.zpjr.cunguan.action.action.login.ILoginAction;
import com.zpjr.cunguan.action.impl.investment.InvestmentActionImpl;
import com.zpjr.cunguan.action.impl.login.LoginActionImpl;
import com.zpjr.cunguan.adapter.ProductListAdapter;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.cache.SharedPreferenceCache;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.common.utils.StringUtils;
import com.zpjr.cunguan.common.views.ClearEditText;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.entity.module.LoginModule;
import com.zpjr.cunguan.presenter.presenter.login.ILoginPresenter;
import com.zpjr.cunguan.ui.activity.login.ForgetPwdFirstActivity;
import com.zpjr.cunguan.ui.activity.login.LoginActivity;
import com.zpjr.cunguan.ui.activity.login.RegisterFirstActivity;
import com.zpjr.cunguan.ui.activity.main.MainActivity;
import com.zpjr.cunguan.ui.activity.security.GestureLockSettingActivity;
import com.zpjr.cunguan.view.investment.IInvestmentListView;
import com.zpjr.cunguan.view.login.IloginView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description:      登录-presenter逻辑处理
 * Autour：          LF
 * Date：            2017/7/27 14:44
 */

public class LoginPresenterImpl extends BasePresenterImpl implements ILoginPresenter, PresenterCallBack {

    private IloginView mView;
    private ILoginAction mAction;

    //启用用户弹框
    private PopupWindow mPopupWindow;

    private boolean mExpand = true;
    private int mImageviewOldHeight;
    private ClearEditText mClet;

    public LoginPresenterImpl(IloginView view) {
        this.mView = view;
        this.mAction = new LoginActionImpl();
    }

    @Override
    public void login() {
        showLoadingDialog(mView.getContext());
        Map<String, String> parameter = mView.getLoginParameter();
        if (checkNull(parameter.get("username"), parameter.get("password"))) {
            mAction.login(parameter, this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //返回
            case R.id.login_backIv:
                ((LoginActivity) mView.getContext()).finish();
                break;
            //登录
            case R.id.login_submitBtn:
                login();
                break;
            //去注册
            case R.id.login_goRegisterTv:
                mView.getContext().startActivity(new Intent(mView.getContext(), RegisterFirstActivity.class));
                break;
            //忘记密码
            case R.id.login_forgetPwdTv:
                mView.getContext().startActivity(new Intent(mView.getContext(), ForgetPwdFirstActivity.class));
                break;
        }
    }

    @Override
    public boolean checkNull(String name, String pwd) {
        if (TextUtils.isEmpty(name)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入手机号", SnackbarUtil.INFO).show();
            return false;

        } else {
            if (!StringUtils.isMobileNO(name)) {
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), "手机号码格式错误", SnackbarUtil.INFO).show();
                return false;
            }
        }
        if (TextUtils.isEmpty(pwd)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入登录密码", SnackbarUtil.INFO).show();
            return false;
        } else if (pwd.length() < 6 || pwd.length() > 16) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入6-16位密码", SnackbarUtil.INFO).show();
            return false;
        }
        return true;
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
        if (!TextUtils.isEmpty(module.getUser().getName())) {
            SharedPreferenceCache.getInstance().putPres("KaiHu", "1");
        } else {
            SharedPreferenceCache.getInstance().putPres("KaiHu", "0");
        }

        //判断手势是否设置
        if (false) {
            mView.getContext().startActivity(new Intent(mView.getContext(),
                    GestureLockSettingActivity.class));
        } else {
            if (MyApplication.getInstance().isExistActivity(MainActivity.class.getName())) {
                ((LoginActivity) mView.getContext()).finish();
            } else {
                Intent intent = new Intent(mView.getContext(), MainActivity.class);
                mView.getContext().startActivity(intent);
            }
        }
        MyApplication.IS_LOGIN = true;
        Log.e("UserInfo", "user:" + String.valueOf(module));
    }

    @Override
    public PopupWindow showPopupWindowTOP() {
        View contentView = LayoutInflater.from(mView.getContext()).inflate(
                R.layout.activity_qiye_top, null);
        mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        TextView tv_login = (TextView) contentView.findViewById(R.id.tv_login);
        tv_login.setText("请去PC端https://zp-bank.com/使用登录");
        // 设置按钮的点击事件 暂不提醒®
        contentView.findViewById(R.id.btn_true).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //清空登录信息
                        mView.getNameClet().setText("");
                        mView.getPwdClet().setText("");
                        mPopupWindow.dismiss();
                    }
                });
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        mPopupWindow.setBackgroundDrawable(dw);
        mPopupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);
        return mPopupWindow;
    }

    @Override
    public void onClearEditTextFocusChange(View view, boolean hasFocus) {
        //设置cleartext是否显示清楚标志
        if (view instanceof ClearEditText) {
            mClet = (ClearEditText) view;
            mClet.hasFoucs = hasFocus;
            if (hasFocus) {
                mClet.setClearIconVisible(mClet.getText().length() > 0);
            } else {
                mClet.setClearIconVisible(false);
            }
        }
        //设置隐藏headerview动画
        if (hasFocus) {
            if (mExpand) {
                final int imageHeight = mView.getHeaderImageIv().getHeight();
                int titlteHeight = mView.getTitleTv().getHeight();
                mImageviewOldHeight = imageHeight;

                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, imageHeight);
                valueAnimator.setDuration(300).start();
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Float value = (Float) animation.getAnimatedValue();
                        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mView.getHeaderImageIv().getLayoutParams();
                        params.height = (int) (imageHeight - value);
                        mView.getHeaderImageIv().requestLayout();
                    }
                });

                PropertyValuesHolder apha = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.6f);
                ObjectAnimator.ofPropertyValuesHolder(mView.getHeaderImageIv(), apha).setDuration(300).start();

                PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.8f);
                PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.8f);
                PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("translationY", 0,
                        0);
                ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(mView.getTitleTv(), scaleX, scaleY, pvhY);
                anim.setDuration(300).start();
                mExpand = false;
            }
        }
    }

    @Override
    public void onSuccess(Object result) {
        dismissLoadingDialog();
        LoginModule module = (LoginModule) JSON.parseObject(result.toString(), LoginModule.class);
        if (module.getUser().enterprise) {
            showPopupWindowTOP();
        } else {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "登录成功", SnackbarUtil.INFO).show();
            saveUserInfo(module);
        }
    }

    @Override
    public void onFail(String errMsg) {
        dismissLoadingDialog();
        SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
    }
}
