package com.zpjr.cunguan.action.impl.login;

import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.login.IRegisterSecondAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Description:      注册第二步-action请求
 * Autour：          LF
 * Date：            2017/8/2 16:18
 */

public class RegisterSecondActionImpl extends BaseAction implements IRegisterSecondAction {

    @Override
    public void getImgCode(final PresenterCallBack callBack) {
        Call<JsonObject> call = mService.getImgCode();
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
    public void checkImgCodeIsRight(String url, Map<String, String> parameter, final PresenterCallBack callBack) {
        Call<JsonObject> call = mService.checkImgCodeIsRight(url, parameter);
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
    public void getRegisterSmsCode(String url, Map<String, String> parameter, final PresenterCallBack callBack) {
        Call<JsonObject> call = mService.getRegisterSmsCode(url, parameter);
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
    public void commitRegister(Map<String, String> parameter, final PresenterCallBack callBack) {
        Call<JsonObject> call = mService.commitRegister(parameter);
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
