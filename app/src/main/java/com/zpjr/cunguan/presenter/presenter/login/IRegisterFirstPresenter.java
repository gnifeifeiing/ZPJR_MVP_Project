package com.zpjr.cunguan.presenter.presenter.login;

import android.view.View;

/**
 * Description:      注册第一步-presenter接口
 * Autour：          LF
 * Date：            2017/8/2 10:23
 */

public interface IRegisterFirstPresenter {

    void onClick(View view);

    boolean checkNull();

    //检测手机号是否注册过
    void checkPhoneIsRegister();

}
