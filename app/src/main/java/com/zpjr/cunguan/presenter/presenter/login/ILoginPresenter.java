package com.zpjr.cunguan.presenter.presenter.login;

import android.view.View;
import android.widget.PopupWindow;

import com.zpjr.cunguan.entity.module.LoginModule;

/**
 * Description:      登录-presenter接口
 * Autour：          LF
 * Date：            2017/7/27 14:43
 */

public interface ILoginPresenter {

    //登录
    void login();

    //点击事件处理
    void onClick(View view);

    //检查输入是否为空
    boolean checkNull(String name,String pwd);

    //保存个人信息
    void saveUserInfo(LoginModule module );

    //企业用户弹出框
    PopupWindow showPopupWindowTOP();

    //输入框获取焦点执行动画
    void onClearEditTextFocusChange(View view, boolean b);
}
