package com.zpjr.cunguan.presenter.presenter.setting;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/8/22 11:31
 */

public interface ICMSWebViewPresenter {

    //获取cms的内容
    void getCmsContent(String url);

    //获取关于我们
    void getAboutUsContent(String url);
}
