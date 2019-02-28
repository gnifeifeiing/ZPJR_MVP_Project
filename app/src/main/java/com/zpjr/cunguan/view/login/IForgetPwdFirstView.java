package com.zpjr.cunguan.view.login;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.zpjr.cunguan.common.base.IBaseView;
import com.zpjr.cunguan.common.views.ClearEditText;

/**
 * Description:      忘记密码第一步-view接口
 * Autour：          LF
 * Date：            2017/8/1 9:54
 */

public interface IForgetPwdFirstView extends IBaseView{

    void initView();

    void initListener();

    //获取手机号码控件
    ClearEditText getPhoneClet();

    //获取验证码控件
    ClearEditText getSmsCodeClet();

    //获取发送验证码控件
    Button getCodeBtn();

    //获取输入管理者
    InputMethodManager getInputManager();
}
