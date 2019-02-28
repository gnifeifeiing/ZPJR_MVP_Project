package com.zpjr.cunguan.view.investment;

import android.support.v7.widget.RecyclerView;

import com.zpjr.cunguan.common.base.IBaseView;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/19 10:32
 */

public interface IPMDInfoView extends IBaseView{

    //设置view控件数据
    void setViewData();

    //获取公司营业执照等信息
    void getCompanyImg();

    //返回recyclerview
    RecyclerView getRecyclerView();
}
