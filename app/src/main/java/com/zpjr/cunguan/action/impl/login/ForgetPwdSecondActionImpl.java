package com.zpjr.cunguan.action.impl.login;

import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.login.IForgetPwdSecondAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Description:      忘记密码第二步-action数据获取
 * Autour：          LF
 * Date：            2017/8/1 17:07
 */

public class ForgetPwdSecondActionImpl extends BaseAction implements IForgetPwdSecondAction{

    @Override
    public void updatePwd(Map<String, String> parameter, final PresenterCallBack callBack) {
        Call<JsonObject> call=mService.updatePwd(parameter);
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
