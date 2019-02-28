package com.zpjr.cunguan.action.impl.setting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.setting.ISettingFragmentAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Description:      设置-action
 * Autour：          LF
 * Date：            2017/8/21 15:06
 */

public class SettingFragmentAction extends BaseAction implements ISettingFragmentAction {

    @Override
    public void getUserInfo( String userId, final PresenterCallBack callBack) {
        Call<JsonObject> call = mService.getUserInfo(userId);
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
    public void getMyCard(String userId,  final PresenterCallBack callBack) {
        setAuthService();
        Call<JsonArray> call = mService.getMyCard(userId);
        call.enqueue(new MyCallBack<JsonArray>() {
            @Override
            public void onSuccess(Response<JsonArray> response) {
                callBack.onSuccess(response.body());
            }

            @Override
            public void onFail(String message) {
                callBack.onFail(message);
            }
        });
    }

    @Override
    public void checkUpdates(final PresenterCallBack callBack) {
        Call<JsonObject> call = mService.checkUpdates("https://bank.zp-bank.com/activity/zpjr_android_version.json");
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
