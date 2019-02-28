package com.zpjr.cunguan.action.impl.login;

import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.login.IForgetPwdFirstAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Description:      忘记密码第一步-action数据获取
 * Autour：          LF
 * Date：            2017/8/1 10:23
 */

public class ForgetPwdFirstActionImpl extends BaseAction implements IForgetPwdFirstAction{

    @Override
    public void checkPhoneRegistered(Map<String, String> parameter, final PresenterCallBack callBack) {
        Call<JsonObject> call=mService.checkPhoneRegistered(parameter);
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
    public void getSmsCode(Map<String, String> parameter, final PresenterCallBack callBack) {
        Call<JsonObject> call=mService.getSmsCode(parameter);
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
    public void checkCode(Map<String, String> parameter, final PresenterCallBack callBack) {
        Call<JsonObject> call=mService.checkCode(parameter);
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
