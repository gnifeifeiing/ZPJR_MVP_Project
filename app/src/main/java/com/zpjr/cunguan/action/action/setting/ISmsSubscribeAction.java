package com.zpjr.cunguan.action.action.setting;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

/**
 * Description:      营销短信订阅
 * Autour：          LF
 * Date：            2017/8/22 16:32
 */

public interface ISmsSubscribeAction {

    //更改订阅状态
    void isSubscribeSms(String userId, String flag, PresenterCallBack callBack);
}
