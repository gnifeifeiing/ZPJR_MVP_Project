package com.zpjr.cunguan.view.investment;

import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.zpjr.cunguan.common.base.IBaseView;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.entity.parameter.InvestmentListParameter;

import java.util.List;

/**
 * Description:      产品列表view接口
 * Autour：          LF
 * Date：            2017/7/11 14:16
 */

public interface IInvestmentListView extends IBaseView {

    //得到投资列表请求参数
    InvestmentListParameter getInvestmentListParameter();

    //获取上下拉刷新控件
    TwinklingRefreshLayout getRefreshLayout();

    //获取recylcerview控件
    RecyclerView getRecyclerview();
}
