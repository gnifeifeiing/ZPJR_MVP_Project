package com.zpjr.cunguan.action.action.setting;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

/**
 * Description:      修改银行预留手机号-action接口
 * Autour：          LF
 * Date：            2017/8/29 11:02
 */

public interface IUpdateBankMobileAction {

    //更换预留手机号
    void changeBankMobile(Map<String, String> parameter, String userId, PresenterCallBack callBack);

    //获取动态验证码
    void getDynamicNumber(Map<String, String> parameter,  PresenterCallBack callBack);
}
