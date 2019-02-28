package com.zpjr.cunguan.presenter.presenter.login;

import android.view.View;

/**
 * Description:      忘记密码第二步-presenter接口
 * Autour：          LF
 * Date：            2017/8/1 17:00
 */

public interface IForgetPwdSecondPresenter {

    //检测输入是否合法
    boolean checkLegal();

    //提交修改
    void commitPwd();

    void onClick(View view);
}
