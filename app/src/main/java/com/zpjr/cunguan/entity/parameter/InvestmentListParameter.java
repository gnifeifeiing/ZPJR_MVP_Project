package com.zpjr.cunguan.entity.parameter;

import com.zpjr.cunguan.common.base.BaseParameter;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/11 10:58
 */

public class InvestmentListParameter extends BaseParameter{
    /**
     * 当前页码
     */
    public String currentPage;
    /**
     * 每页条数
     */
    public String pageSize;
    /**
     * 状态
     */
    public String status;
    public String minDuration;
    public String maxDuration;
    public String minRate;
    public String maxRate;
    /**
     * 产品类型
     */
    public String product;
}
