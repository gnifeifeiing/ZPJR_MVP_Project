package com.zpjr.cunguan.presenter.presenter.login;

import android.view.View;

import com.zpjr.cunguan.entity.module.LoginModule;
import com.zpjr.cunguan.entity.module.RegisterResponseModule;

/**
 * Description:      注册第二步-presenter接口
 * Autour：          LF
 * Date：            2017/8/2 16:12
 */

public interface IRegisterSecondPresenter {

    void onClick(View view);

    //获取图形码
    void getImgCode();

    //验证图形码
    void checkImgCodeIsRight();

    //获取验证码
    void getRegisterCode();

    //注册提交
    void commitRegister();

    //验证表单信息
    boolean checkFormInfo();

    //注册成功自动登录
    void autoLogin();

    //保存用户信息
    void saveUserInfo(LoginModule module);
}
