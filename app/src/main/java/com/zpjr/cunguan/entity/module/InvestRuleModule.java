package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseModule;

/**
 * Description:      投资规则
 * Autour：          LF
 * Date：            2017/7/11 11:27
 */

public class InvestRuleModule extends BaseModule {
    /**
     *
     */
    private static final long serialVersionUID = -8565358422216590335L;

    /**
     * 最新投资金额
     */
    public int minAmount;

    /**
     * 最大投资金额
     */
    public int maxAmount;

    /**
     * 递增金额
     */
    public int stepAmount;

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getStepAmount() {
        return stepAmount;
    }

    public void setStepAmount(int stepAmount) {
        this.stepAmount = stepAmount;
    }

}
