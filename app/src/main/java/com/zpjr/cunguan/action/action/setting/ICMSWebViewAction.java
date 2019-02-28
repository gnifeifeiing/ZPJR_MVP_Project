package com.zpjr.cunguan.action.action.setting;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/8/22 11:34
 */

public interface ICMSWebViewAction {
    //获取cms的内容
    void getCmsContent(String url,   PresenterCallBack callBack);

    //获取关于我们的内容
    void getAboutUsContent(String url, final PresenterCallBack callBack);
}
