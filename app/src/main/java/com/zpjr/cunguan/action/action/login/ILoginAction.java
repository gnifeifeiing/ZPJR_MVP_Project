package com.zpjr.cunguan.action.action.login;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

/**
 * Description:      登录
 * Autour：          LF
 * Date：            2017/7/27 14:46
 */

public interface ILoginAction {
    //登录
    void login(Map<String, String> parameter, final PresenterCallBack callBack);
}
