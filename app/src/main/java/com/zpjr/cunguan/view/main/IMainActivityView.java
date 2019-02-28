package com.zpjr.cunguan.view.main;

import com.zpjr.cunguan.common.base.IBaseView;

/**
 * Description:      主页view接口
 * Autour：          LF
 * Date：            2017/7/14 11:32
 */

public interface IMainActivityView extends IBaseView {

    //初始化view
    void initView();

    //初始化事件
    void initEvent();

    //初始化fragment
    void initMainFragment();
}
