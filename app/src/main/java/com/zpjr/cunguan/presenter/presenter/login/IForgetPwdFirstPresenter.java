package com.zpjr.cunguan.presenter.presenter.login;

import android.view.View;

import java.util.Map;

/**
 * Description:      忘记密码第一步-presenter接口
 * Autour：          LF
 * Date：            2017/8/1 10:13
 */

public interface IForgetPwdFirstPresenter {

    //检测用户输入是否合法
    void checkNullAndSendSms();

    //判断手机号是否注册
    void checkPhoneRegistered(String phoneNumber);

    //发送验证码
    void getSmsCode(Map<String, String> parameter);

    void onClick(View view);

    //点击下一步时检测用户输入是否合法
    boolean nextCheckNull();

    //检测验证码是否正确
    void checkCode();

    //销毁短信观察者
    void destoryObserver();
}
