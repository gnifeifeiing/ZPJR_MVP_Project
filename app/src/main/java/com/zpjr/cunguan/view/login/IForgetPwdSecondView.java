package com.zpjr.cunguan.view.login;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.zpjr.cunguan.common.base.IBaseView;
import com.zpjr.cunguan.common.views.ClearEditText;

/**
 * Description:      忘记密码第二步-view接口
 * Autour：          LF
 * Date：            2017/8/1 16:53
 */

public interface IForgetPwdSecondView extends IBaseView{

    void initView();

    void initListener();

    //获取新密码控件
    ClearEditText getNewPwdClet();

    //获取确认密码控件
    ClearEditText getCommitPwdClet();

    //获取提交控件
    Button getSubmitBtn();

    //获取输入管理者
    InputMethodManager getInputManager();

}
