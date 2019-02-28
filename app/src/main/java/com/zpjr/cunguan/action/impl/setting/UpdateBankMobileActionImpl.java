package com.zpjr.cunguan.action.impl.setting;

import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.setting.IUpdateBankMobileAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Description:      修改银行预留手机号-action
 * Autour：          LF
 * Date：            2017/8/29 11:04
 */

public class UpdateBankMobileActionImpl extends BaseAction implements IUpdateBankMobileAction {

    @Override
    public void changeBankMobile(Map<String, String> parameter, String userId, final PresenterCallBack callBack) {
        setAuthService();
        Call<JsonObject> call = mService.changeBankMobile(parameter, userId);
        call.enqueue(new MyCallBack<JsonObject>() {
            @Override
            public void onSuccess(Response<JsonObject> response) {
                callBack.onSuccess(response.body());
            }

            @Override
            public void onFail(String message) {
                callBack.onFail(message);
            }
        });
    }

    @Override
    public void getDynamicNumber(Map<String, String> parameter, final PresenterCallBack callBack) {
        Call<JsonObject> call = mService.getDynamicNumber(parameter);
        call.enqueue(new MyCallBack<JsonObject>() {
            @Override
            public void onSuccess(Response<JsonObject> response) {
                callBack.onSuccess(response.body());
            }

            @Override
            public void onFail(String message) {
                callBack.onFail(message);
            }
        });
    }

}
