package com.zpjr.cunguan.view.investment;

import android.widget.TextView;

import com.zpjr.cunguan.common.base.IBaseView;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/18 11:11
 */

public interface IProductDetailView extends IBaseView {


    //初始化view
    void initView();

    //初始化监听
    void initListener();

    //获取loanModule
    void getLoanModule();

    //设置view值
    void setViewModule();
}
