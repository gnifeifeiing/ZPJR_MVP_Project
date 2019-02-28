package com.zpjr.cunguan.action.impl.setting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.setting.ICMSWebViewAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/8/22 11:36
 */

public class CMSWebViewActionImpl extends BaseAction implements ICMSWebViewAction{

    @Override
    public void getCmsContent(String url, final PresenterCallBack callBack) {
        Call<JsonArray> call = mService.getCmsContent(url);
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
    public void getAboutUsContent(String url, final PresenterCallBack callBack) {
        Call<JsonArray> call = mService.getAboutUsContent(url);
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
}
