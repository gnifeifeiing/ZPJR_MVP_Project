package com.zpjr.cunguan.presenter.impl.setting;

import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.zpjr.cunguan.action.action.setting.ISmsSubscribeAction;
import com.zpjr.cunguan.action.impl.setting.SmsSubscribeActionImpl;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.cache.SharedPreferenceCache;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.entity.module.MyCardRechangeResponseModule;
import com.zpjr.cunguan.presenter.presenter.setting.ISmsSubscribePresenter;
import com.zpjr.cunguan.ui.activity.setting.SmsSubscribeActivity;
import com.zpjr.cunguan.view.setting.ISmsSubscribeView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:      短信订阅
 * Autour：          LF
 * Date：            2017/8/22 16:30
 */

public class SmsSubscribePresenterImpl extends BasePresenterImpl implements ISmsSubscribePresenter {

    private ISmsSubscribeView mView;
    private ISmsSubscribeAction mAction;

    public SmsSubscribePresenterImpl(ISmsSubscribeView view){
        this.mView=view;
        this.mAction=new SmsSubscribeActionImpl();
    }

    @Override
    public void isSubscribeSms(String flag) {
        mAction.isSubscribeSms(SharedPreferenceCache.getInstance().getPres("UserId"),flag, new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                MyCardRechangeResponseModule response= JSONObject.parseObject(result.toString(),MyCardRechangeResponseModule.class);
                if (response.isSuccess()) {
                    String data = response.getData();
                    if("SUBSCRIBE_ERROR".equals(data)){
                        SnackbarUtil.ShortSnackbar(mView.getActivityView(), "操作失败", SnackbarUtil.INFO).show();
                    }else if ("SUBSCRIBE_SUCCESS".equals(data)){
                        SnackbarUtil.ShortSnackbar(mView.getActivityView(), "订阅成功", SnackbarUtil.INFO).show();
                    }else if ("CANCEL_SUCCESS".equals(data)){
                        SnackbarUtil.ShortSnackbar(mView.getActivityView(), "已取消订阅", SnackbarUtil.INFO).show();
                    }else if ("CZBANK_BALANCE_TRANSFER_NO_USER".equals(data)){
                        SnackbarUtil.ShortSnackbar(mView.getActivityView(), "用户不存在", SnackbarUtil.INFO).show();
                    }
                    ((SmsSubscribeActivity)mView.getContext()).finish();
                } else {
                    if (response.getError() != null && response.getError().size() > 0) {
                        if (response.getError().get(0).getMessage() != null) {
                            SnackbarUtil.ShortSnackbar(mView.getActivityView(), response.getError().get(0).getMessage(), SnackbarUtil.INFO).show();
                        }
                    }

                }
            }

            @Override
            public void onFail(String errMsg) {
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
            }
        });
    }
}
