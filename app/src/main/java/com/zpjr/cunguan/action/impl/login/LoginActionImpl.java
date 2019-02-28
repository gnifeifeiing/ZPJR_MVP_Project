package com.zpjr.cunguan.action.impl.login;

import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.login.ILoginAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Description:      登录
 * Autour：          LF
 * Date：            2017/7/27 14:48
 */

public class LoginActionImpl extends BaseAction implements ILoginAction {

    @Override
    public void login(Map<String, String> parameter, final PresenterCallBack callBack) {
        Call<JsonObject> call=mService.login(parameter);
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
