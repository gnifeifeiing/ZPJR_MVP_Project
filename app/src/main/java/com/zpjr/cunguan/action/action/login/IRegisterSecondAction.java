package com.zpjr.cunguan.action.action.login;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

/**
 * Description:      注册第二步-action接口
 * Autour：          LF
 * Date：            2017/8/2 16:17
 */

public interface IRegisterSecondAction {
    //获取图形码
    void getImgCode( PresenterCallBack callBack);

    //验证图形码
    void checkImgCodeIsRight(String url, Map<String, String> parameter,  PresenterCallBack callBack);

    //发送验证码
    void getRegisterSmsCode(String url, Map<String, String> parameter,  PresenterCallBack callBack);

    //注册
    void commitRegister(Map<String, String> parameter,  PresenterCallBack callBack);


}
