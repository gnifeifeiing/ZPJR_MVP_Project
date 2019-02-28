package com.zpjr.cunguan.presenter.presenter.main;

import android.view.View;

/**
 * Description:      主页presenter
 * Autour：          LF
 * Date：            2017/7/14 11:37
 */

public interface IMainActivityPresenter {

    //将所有的Fragment都置为隐藏状态。
    void hideFragments();

    //点击选择显示fragment
    void showFragment(View view);

    //设置初始显示的fragment
    void setInitFragment();
}
