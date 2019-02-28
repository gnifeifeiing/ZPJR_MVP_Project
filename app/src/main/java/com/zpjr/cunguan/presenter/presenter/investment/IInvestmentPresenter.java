package com.zpjr.cunguan.presenter.presenter.investment;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.zpjr.cunguan.entity.module.LoanModule;

import java.util.List;

/**
 * Description:      产品列表presenter接口
 * Autour：          LF
 * Date：            2017/7/11 14:28
 */

public interface IInvestmentPresenter {

    //刷新数据
    void onRefresh();

    //加载更多
    void onLoadMore();

    //获取产品列表
    void getProductList();

    //设置适配器
    void setRecyclerviewAdapter();

    //结束刷新
    void finishRefreshing();

}
