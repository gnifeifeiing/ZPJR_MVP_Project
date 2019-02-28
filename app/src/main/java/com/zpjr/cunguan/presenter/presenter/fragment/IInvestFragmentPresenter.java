package com.zpjr.cunguan.presenter.presenter.fragment;

import android.support.v4.view.ViewPager;

import com.zpjr.cunguan.common.views.WDTabPageIndicator;

/**
 * Description:      产品列表的fragmentActivity presenter接口
 * Autour：          LF
 * Date：            2017/7/17 14:15
 */

public interface IInvestFragmentPresenter  {

    //初始化fragmnet
    void initFragment(ViewPager viewPager, WDTabPageIndicator indicator);

}
