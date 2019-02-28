package com.zpjr.cunguan.presenter.impl.setting;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.action.action.setting.IUpdateBankMobileAction;
import com.zpjr.cunguan.action.impl.setting.UpdateBankMobileActionImpl;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.cache.SharedPreferenceCache;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.CommonUtils;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.common.utils.StringUtils;
import com.zpjr.cunguan.entity.module.ApiResponseModule;
import com.zpjr.cunguan.presenter.presenter.setting.IUpdateBankMobilePresenter;
import com.zpjr.cunguan.ui.activity.setting.UpdateBankMobileActivity;
import com.zpjr.cunguan.view.setting.IUpdateBankMobileView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:      修改银行预留手机号-presenter
 * Autour：          LF
 * Date：            2017/8/29 11:01
 */

public class UpdateBankMobilePresenterImpl extends BasePresenterImpl implements IUpdateBankMobilePresenter {

    private IUpdateBankMobileAction mAction;
    private IUpdateBankMobileView mView;

    private CountDownTask mTask;

    private String mBindSerialNo;
    private String mNewMobleNumber;
    private String mOldMobleNumber;
    private String mBindPhoneCode;

    public UpdateBankMobilePresenterImpl(IUpdateBankMobileView view, String bindSerialNo) {
        this.mView = view;
        this.mAction = new UpdateBankMobileActionImpl();
        this.mBindSerialNo = bindSerialNo;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.updateBankMobile_dynamicNumberTv:
                if (!StringUtils.isEmpty(mBindSerialNo)) {
                    getDynamicNumber();
                }
                break;
            case R.id.updateBankMobile_commitBtn:
                changeBankMobile();
                break;
        }
    }


    @Override
    public void changeBankMobile() {
        mOldMobleNumber = mView.getmOldPhoneEt().getText().toString().trim();
        if (StringUtils.isEmpty(mOldMobleNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入银行原预留手机号", SnackbarUtil.INFO).show();
            return;
        }
        if (!mOldMobleNumber.matches(CommonUtils.REGEX_TELREGEX)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "银行原预留手机号格式不对", SnackbarUtil.INFO).show();
            return;
        }
        mNewMobleNumber = mView.getmNewPhoneEt().getText().toString().trim();
        if (StringUtils.isEmpty(mNewMobleNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入银行新预留手机号", SnackbarUtil.INFO).show();
            return;
        }
        if (!mNewMobleNumber.matches(CommonUtils.REGEX_TELREGEX)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "银行新预留手机号格式不对", SnackbarUtil.INFO).show();
            return;
        }
        if (!SharedPreferenceCache.getInstance().getPres("BankMobile").equals(mOldMobleNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "银行原预留手机号不正确", SnackbarUtil.INFO).show();
            return;
        }
        mBindPhoneCode = mView.getmDynamicNumberEt().getText().toString().trim();
        if (StringUtils.isEmpty(mBindPhoneCode)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入短信验证码", SnackbarUtil.INFO).show();
            return;
        }
        showLoadingDialog(mView.getContext());
        Map<String, String> parameter = new HashMap<>();
        parameter.put("mobileNow", mNewMobleNumber);
        parameter.put("mobileCode", mBindPhoneCode);
        mAction.changeBankMobile(parameter, SharedPreferenceCache.getInstance().getPres("UserId"), new PresenterCallBack() {

            @Override
            public void onSuccess(Object result) {
                dismissLoadingDialog();
                ApiResponseModule module = (ApiResponseModule) JSON.parseObject(result.toString(), ApiResponseModule.class);
                if (module.isSuccess()) {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "更换成功", SnackbarUtil.INFO).show();
                    ((UpdateBankMobileActivity)mView.getContext()).finish();
                } else {
                    if (module.getError() != null && module.getError().size() > 0) {
                        if (!StringUtils.isEmpty(module.getError().get(0).getMessage())) {
                            SnackbarUtil.ShortSnackbar(mView.getActivityView(),  module.getError().get(0).getMessage(), SnackbarUtil.INFO).show();
                        }
                    }else {
                        SnackbarUtil.ShortSnackbar(mView.getActivityView(), module.getErrorMessage(), SnackbarUtil.INFO).show();
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
                dismissLoadingDialog();
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
            }
        });
    }

    @Override
    public void getDynamicNumber() {
        mNewMobleNumber = mView.getmNewPhoneEt().getText().toString().trim();
        if (StringUtils.isEmpty(mNewMobleNumber)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "请输入新版银行预留手机号", SnackbarUtil.INFO).show();
            return;
        }
        if (!mNewMobleNumber.matches(CommonUtils.REGEX_TELREGEX)) {
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "新版银行预留手机号格式不对", SnackbarUtil.INFO).show();
            return;
        }
        showLoadingDialog(mView.getContext(), "获取验证码...");
        Map<String, String> parameter = new HashMap<>();
        parameter.put("mobile", mNewMobleNumber);
        parameter.put("smsType", "CHANGEMOBILE");
        parameter.put("extension", mBindSerialNo);
        mAction.getDynamicNumber(parameter, new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                dismissLoadingDialog();
                ApiResponseModule module = (ApiResponseModule) JSON.parseObject(result.toString(), ApiResponseModule.class);
                if (module.isSuccess()) {
                    mTask = new CountDownTask();
                    mTask.execute();
                    mView.getmSendMessageTv().setVisibility(View.VISIBLE);
                    mView.getmSendMessageTv().setText(String.format("短信已发送至%1$s", mNewMobleNumber));
                } else {
                    if (module.getError() != null && module.getError().size() > 0) {
                        if (!StringUtils.isEmpty(module.getError().get(0).getMessage())) {
                            SnackbarUtil.ShortSnackbar(mView.getActivityView(), module.getError().get(0).getMessage(), SnackbarUtil.INFO).show();
                        }
                    } else {
                        SnackbarUtil.ShortSnackbar(mView.getActivityView(), module.getErrorMessage(), SnackbarUtil.INFO).show();
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
                dismissLoadingDialog();
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
            }
        });
    }


    private class CountDownTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            mView.getmDynamicNumberTv().setEnabled(false);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void result) {
            mView.getmDynamicNumberTv().setEnabled(true);
            mView.getmDynamicNumberTv().setText(mView.getContext().getString(R.string.regesiter_getcode));
            super.onPostExecute(result);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 60; i >= 0; i--) {
                try {
                    System.out.println("---------" + i);
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
            mView.getmDynamicNumberTv().setText("重新发送(" + values[0] + ")");
            super.onProgressUpdate(values);
        }
    }
}
