package com.zpjr.cunguan.presenter.presenter.fragment;

import android.view.View;

/**
 * Description:      设置 presenter接口
 * Autour：          LF
 * Date：            2017/8/21 14:55
 */

public interface ISettingFragmentPresenter {

    //获取app版本相关信息
    void getVersionInfo();

    //进入时登录判断
    void checkLoginstate();

    //获取用户信息
    void getUserInfo();

    //获取是否绑卡信息
    void getMyCard();

    //检查更新
    void checkUpdates();

    //短信订阅状态
    void setSmsSubscribeState();

    //点击事件
    void onClick(View view);
}
