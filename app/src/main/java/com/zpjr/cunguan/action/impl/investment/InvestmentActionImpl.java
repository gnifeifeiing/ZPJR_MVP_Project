package com.zpjr.cunguan.action.impl.investment;

import com.google.gson.JsonObject;
import com.zpjr.cunguan.action.action.investment.IInvestmentAction;
import com.zpjr.cunguan.common.base.BaseAction;
import com.zpjr.cunguan.common.retrofit.MyCallBack;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.entity.module.LoanModule;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/11 14:44
 */

public class InvestmentActionImpl extends BaseAction implements IInvestmentAction {

    @Override
    public void getProductList(Map<String, String> patameter,final PresenterCallBack callBack) {
        Call<JsonObject> call=mService.getProductList(patameter);
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
