package com.zpjr.cunguan.action.impl.investment;

import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.investment.IPMDInfoAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Description:      更多详情--项目信息接口
 * Autour：          LF
 * Date：            2017/7/19 14:24
 */

public class PMDInfoActionImpl extends BaseAction implements IPMDInfoAction {

    @Override
    public void getCompanyImg(String loanId, final PresenterCallBack callBack) {
        Call<JsonObject> call=mService.getCompanyImg(loanId);
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
