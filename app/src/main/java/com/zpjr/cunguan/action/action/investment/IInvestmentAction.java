package com.zpjr.cunguan.action.action.investment;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.entity.module.LoanModule;

import java.util.List;
import java.util.Map;

/**
 * Description:      产品列表action接口
 * Autour：          LF
 * Date：            2017/7/11 14:41
 */

public interface IInvestmentAction {
    //获取产品列表
    void getProductList(Map<String, String> patameter, final PresenterCallBack callBack);
}
