package com.zpjr.cunguan.action.action.login;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

/**
 * Description:      忘记密码第一步-action接口
 * Autour：          LF
 * Date：            2017/8/1 10:21
 */

public interface IForgetPwdFirstAction {

    //验证手机号是否注册过
    void checkPhoneRegistered(Map<String, String> parameter, final PresenterCallBack callBack);

    //获取验证码
    void getSmsCode(Map<String, String> parameter, final PresenterCallBack callBack);

    //检测验证码是否正确
    void checkCode(Map<String, String> parameter, final PresenterCallBack callBack);
}
