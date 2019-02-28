package com.zpjr.cunguan.view.login;

import android.view.inputmethod.InputMethodManager;

import com.zpjr.cunguan.common.base.IBaseView;
import com.zpjr.cunguan.common.views.ClearEditText;

/**
 * Description:      注册第一步-view接口
 * Autour：          LF
 * Date：            2017/8/2 10:19
 */

public interface IRegisterFirstView extends IBaseView {

    void initView();

    void initListener();

    //获取手机号码控件
    ClearEditText getPhoneClet();

    //获取输入管理者
    InputMethodManager getInputManager();

}
