package com.zpjr.cunguan.action.action.login;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

/**
 * Description:      忘记密码第二步-action接口
 * Autour：          LF
 * Date：            2017/8/1 17:05
 */

public interface IForgetPwdSecondAction {
    //验证手机号是否注册过
    void updatePwd(Map<String, String> parameter, final PresenterCallBack callBack);
}
