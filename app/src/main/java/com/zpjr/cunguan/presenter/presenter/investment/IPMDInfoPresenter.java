package com.zpjr.cunguan.presenter.presenter.investment;

import android.webkit.WebView;

/**
 * Description:      更多详情--项目信息接口
 * Autour：          LF
 * Date：            2017/7/19 11:01
 */

public interface IPMDInfoPresenter {

    //获取公司营业执照等信息
    void getCompanyImg(String loanId);

    //设置webview内容
    void webViewInitialByContent(WebView webViews,String content);

    //销毁webview
    void clearWebView(WebView... webViews);
}
