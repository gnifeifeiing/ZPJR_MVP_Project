package com.zpjr.cunguan.presenter.impl.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zpjr.cunguan.MyApplication;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.action.action.setting.ISettingFragmentAction;
import com.zpjr.cunguan.action.impl.setting.SettingFragmentAction;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.cache.SharedPreferenceCache;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.Constants;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.common.utils.StringUtils;
import com.zpjr.cunguan.entity.module.ApiResponseModule;
import com.zpjr.cunguan.entity.module.FundAccountModule;
import com.zpjr.cunguan.entity.module.UserMessageResponseModule;
import com.zpjr.cunguan.entity.module.VersionModule;
import com.zpjr.cunguan.presenter.presenter.fragment.ISettingFragmentPresenter;
import com.zpjr.cunguan.ui.activity.login.LoginActivity;
import com.zpjr.cunguan.ui.activity.main.MainActivity;
import com.zpjr.cunguan.ui.activity.my.OpenWarmPromptActivity;
import com.zpjr.cunguan.ui.activity.setting.CMSWebViewActivity;
import com.zpjr.cunguan.ui.activity.setting.HelpActivity;
import com.zpjr.cunguan.ui.activity.setting.SmsSubscribeActivity;
import com.zpjr.cunguan.ui.activity.setting.UpdateBankMobileActivity;
import com.zpjr.cunguan.ui.fragment.SettingFragment;
import com.zpjr.cunguan.view.fragment.IInvestFragmnetView;
import com.zpjr.cunguan.view.fragment.ISettingFragmentView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Description:      设置的presenter
 * Autour：          LF
 * Date：            2017/8/21 14:55
 */

public class SettingFragmentPresenterImpl extends BasePresenterImpl implements ISettingFragmentPresenter {

    private ISettingFragmentView mView;
    private ISettingFragmentAction mAction;

    private UserMessageResponseModule.CzAccountBean mCzAccountBean;

    /**
     * 用户短信订阅状态：0-取消订阅  1-已订阅
     */
    private int subscribe = 1;

    private boolean mUserIdAuth = false;
    private String mBindSerialNo;

    private boolean mHaveRechargeCard;
    private FundAccountModule mRechargeAccount;
    private boolean mHaveDrawCard;
    private FundAccountModule mDrawAccount;

    private String mCurrentVersionName;
    private int mCurrentVersionNo;
    //版本更新的module
    private VersionModule mVersionModule;

    public SettingFragmentPresenterImpl(ISettingFragmentView view) {
        this.mView = view;
        this.mAction = new SettingFragmentAction();
    }

    @Override
    public void getVersionInfo() {
        mCurrentVersionName = ((MainActivity) mView.getContext()).getVersionName();
        mCurrentVersionNo = ((MainActivity) mView.getContext()).getAppVersion();
        mView.getmApkVersionTv().setText(mCurrentVersionName);
    }

    @Override
    public void checkLoginstate() {
        if (MyApplication.IS_LOGIN) {
            mView.getmHadLoginLl().setVisibility(View.VISIBLE);
            mView.getmLogoutSettingBtn().setText(R.string.logout);
            mView.getmLogoutSettingBtn().setBackgroundResource(R.drawable.btn_basecolor_selector);
            mView.getmLogoutSettingBtn().setTextColor(0xff2A99E6);
            //获取用户、绑卡信息
            getUserInfo();
            getMyCard();
        } else {
            mView.getmHadLoginLl().setVisibility(View.GONE);
            mView.getmLogoutSettingBtn().setText("快速登录");
            mView.getmLogoutSettingBtn().setBackgroundResource(R.drawable.btn_blue);
            mView.getmLogoutSettingBtn().setTextColor(Color.WHITE);
        }
        //检查更新
        checkUpdates();
    }

    @Override
    public void getUserInfo() {
        mAction.getUserInfo(SharedPreferenceCache.getInstance().getPres("UserId"), new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                UserMessageResponseModule module = JSON.parseObject(result.toString(), UserMessageResponseModule.class);
                subscribe = module.getUserInfo().getUser().getSubscribe();
                setSmsSubscribeState();
                mCzAccountBean = module.getCzAccount();
                if (mCzAccountBean != null && mCzAccountBean.getUserId() != null) {
                    mUserIdAuth = true;
                    //设置已开户
                    SharedPreferenceCache.getInstance().putPres("KaiHu", "1");
                    if (module.getCzAccount().getAccountName() != null) {
                        mView.getmUserNameTv().setText(module.getCzAccount().getAccountName());
                    }
                    mView.getmHadApproveTv().setText(R.string.text_auth_open);
                    mView.getmOpenDepositIv().setVisibility(View.INVISIBLE);

                    mBindSerialNo = mCzAccountBean.getBindSerialNo();
                } else {
                    mUserIdAuth = false;
                    //设置未开户
                    SharedPreferenceCache.getInstance().putPres("KaiHu", "0");
                    String user_phone = module.getUserInfo().getUser().getMobile();
                    if (user_phone.length() == 11)
                        mView.getmUserNameTv().setText(user_phone.substring(0, 3) + "****" + user_phone.substring(7));
                    else
                        mView.getmUserNameTv().setText("***");
                    mView.getmHadApproveTv().setText(R.string.text_not_auth_open);
                    mView.getmOpenDepositIv().setVisibility(View.VISIBLE);
                }
                if (module.getCzAccount() != null) {
                    String bankmobile = module.getCzAccount().getMobile();
                    String banktype = module.getCzAccount().getType();
                    if (!StringUtils.isEmpty(bankmobile) && !StringUtils.isEmpty(banktype)) {
                        SharedPreferenceCache.getInstance().putPres("BankMobile", bankmobile);
                        SharedPreferenceCache.getInstance().putPres("BankType", banktype);
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
            }
        });
    }

    @Override
    public void getMyCard() {
        mAction.getMyCard(SharedPreferenceCache.getInstance().getPres("UserId"), new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                if (result != null) {
                    List<FundAccountModule> list = JSON.parseArray(result.toString(), FundAccountModule.class);
                    if (list != null && list.size() > 0) {
                        FundAccountModule defaultaccount = null;
                        for (FundAccountModule account : list) {
                            if (defaultaccount == null) {
                                defaultaccount = account;
                            } else {
                                if (account.isDefaultAccount()) {
                                    defaultaccount = account;
                                }
                            }
                        }
                        //默认账户不为空-则已绑定
                        if (defaultaccount != null) {
                            mView.getmHadBindingTv().setText("已绑定");
                            mHaveRechargeCard = true;
                            mRechargeAccount = defaultaccount;
                            mHaveDrawCard = true;
                            mDrawAccount = defaultaccount;
                        } else {
                            mView.getmHadBindingTv().setText("未绑定");
                            mHaveRechargeCard = false;
                            mHaveDrawCard = false;
                        }

                    } else {
                        mView.getmHadBindingTv().setText("未绑定");
                        mHaveRechargeCard = false;
                        mHaveDrawCard = false;
                    }
                } else {
                    mView.getmHadBindingTv().setText("未绑定");
                    mHaveRechargeCard = false;
                    mHaveDrawCard = false;
                }
            }

            @Override
            public void onFail(String errMsg) {
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
                mView.getmHadBindingTv().setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void checkUpdates() {
        mView.getmApkVersionTv().setText(mView.getContext().getString(R.string.more_checkupdating));
        mAction.checkUpdates(new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                if (result != null) {
                    VersionModule module = JSONObject.parseObject(result.toString(), VersionModule.class);
                    if (module.getVersionCode() <= mCurrentVersionNo) {
                        mView.getmApkVersionTv().setText(mCurrentVersionName);
                        mVersionModule = module;
                    } else {
                        //当有高版本时，判断url是否存在
                        if (!TextUtils.isEmpty(module.getUrl())) {
                            if (TextUtils.isEmpty(module.getName())) {
                                module.setName(mView.getContext().getString(R.string.app_name));
                            }
                            if (TextUtils.isEmpty(module.getVersionName())) {
                                module.setVersionName("新版本");
                            }
                            mVersionModule = module;
                            mView.getmApkVersionTv().setText("新版本" + module.getVersionName());

                        } else {
                            mView.getmApkVersionTv().setText(mCurrentVersionName);
                        }
                    }
                } else {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "检查更新失败，请重试", SnackbarUtil.INFO).show();
                    mView.getmApkVersionTv().setText(mCurrentVersionName);
                }
            }

            @Override
            public void onFail(String errMsg) {
                try {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
                    mView.getmApkVersionTv().setText(mCurrentVersionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void setSmsSubscribeState() {
        //已订阅
        if (subscribe == 1) {
            mView.getmChangeSmsSubscribeTv().setText("已订阅");
        }
        //已取消
        else {
            mView.getmChangeSmsSubscribeTv().setText("未订阅");
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.setting_messageCenterLl:
//                Intent intent = new Intent(mView.getContext(), NotificationActivity.class);
//                startActivity(intent);
                break;
            case R.id.setting_truthNameLl:
//                if (!userIdAuth) {
//                    Intent intent_auth = new Intent(mView.getContext(), OpenWarmPromptActivity.class);
//                    startActivity(intent_auth);
//                }
                break;
            case R.id.setting_myBankCardLl:
//                if (haveRechargeCard)
//                    MyCardActivity.startAc(mView.getContext(), haveRechargeCard, haveDrawCard, rechargeAccount,
//                            drawAccount);
//                else {
//                    Intent intent_au = new Intent(mView.getContext(), OpenWarmPromptActivity.class);
//                    startActivity(intent_au);
//                }
                break;
            case R.id.setting_loginPasswordLl:
//                ForgetPasswordActivity.startAc(mView.getContext(), ForgetPasswordActivity.UPDATE);
                break;
            //修改银行预留手机号
            case R.id.setting_bankPhonenumberLl:
                if (!StringUtils.isEmpty(mBindSerialNo)) {
                    intent = new Intent(mView.getContext(), UpdateBankMobileActivity.class);
                    intent.putExtra("bindSerialNo", mBindSerialNo);
                    mView.getContext().startActivity(intent);
                } else {
                    intent = new Intent(mView.getContext(), OpenWarmPromptActivity.class);
                    mView.getContext().startActivity(intent);
                }
                break;
            case R.id.setting_gesturePasswordLl:
//                ForgetGestureActivity.startAc(mView.getContext(), ForgetGestureActivity.UPDATE);
                break;
            case R.id.setting_aboutUsLl:
                intent = new Intent(mView.getContext(), CMSWebViewActivity.class);
                intent.putExtra("title", "关于我们");
                intent.putExtra("url", "关于我们");
                mView.getContext().startActivity(intent);
                break;
            case R.id.setting_helpCenterLl:
                intent = new Intent(mView.getContext(), HelpActivity.class);
                mView.getContext().startActivity(intent);
                break;
            //联系客服
            case R.id.setting_callServersLl:
                showCallDialog(mView.getContext(), "呼叫：400-680-8686");
                break;
            //软件版本
            case R.id.setting_softVersionLl:
                if (mVersionModule == null) {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "网络连接错误", SnackbarUtil.INFO).show();
                } else if (mVersionModule.getVersionCode() <= mCurrentVersionNo) {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "当前版本为最新版本", SnackbarUtil.INFO).show();
                } else {
                    showUpdateDialog(mView.getContext(),
                            mVersionModule.getUrl(),
                            mVersionModule.getName(),
                            mVersionModule.getVersionName());
                }
                break;
            //退出登录
            case R.id.setting_logoutSettingBtn:
                if (MyApplication.IS_LOGIN) {
                    showLogOutDialog(mView.getContext());
                } else {
                    intent = new Intent(mView.getContext(), LoginActivity.class);
                    intent.putExtra("table", 4);
                    mView.getContext().startActivity(intent);
                }
                break;
            //短信订阅
            case R.id.setting_smsSubscribeLl:
                intent = new Intent(mView.getContext(), SmsSubscribeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("subscribe", subscribe);
                intent.putExtras(bundle);
                mView.getContext().startActivity(intent);
                break;
        }
    }
}
