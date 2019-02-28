package com.zpjr.cunguan.presenter.presenter.investment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/18 17:58
 */

public interface IProductMoreDetailPresenter {

    //初始化fragmetn列表
    void initFragment(ViewPager viewPager, TextView... textViews);

    //初始点击事件
    void onClick(View view, ViewPager viewPager);
}
