package com.zpjr.cunguan.presenter.presenter.setting;

/**
 * Description:      营销短信
 * Autour：          LF
 * Date：            2017/8/22 16:28
 */

public interface ISmsSubscribePresenter {

    /**
     * 取消订阅 flag:0
     * 重新订阅 flag:1
     */
    void isSubscribeSms(String flag);
}
