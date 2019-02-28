package com.zpjr.cunguan.presenter.presenter.setting;

import android.view.View;

/**
 * Description:      修改银行预留手机号-presenter接口
 * Autour：          LF
 * Date：            2017/8/29 11:00
 */

public interface IUpdateBankMobilePresenter {
    //更换预留手机号
    void changeBankMobile();

    //获取新手机号码的验证码
    void getDynamicNumber();

    //点击事件
    void onClick(View view);
}
