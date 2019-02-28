package com.zpjr.cunguan.action.impl.setting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.setting.ISmsSubscribeAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Path;

/**
 * Description:      营销短信订阅-action
 * Autour：          LF
 * Date：            2017/8/22 16:34
 */

public class SmsSubscribeActionImpl extends BaseAction implements ISmsSubscribeAction {

    @Override
    public void isSubscribeSms(String userId, String flag, final PresenterCallBack callBack) {
        setAuthService();
        Call<JsonObject> call = mService.isSubscribeSms(userId, flag);
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
