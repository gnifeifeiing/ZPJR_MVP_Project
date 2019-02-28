package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseModule;

/**
 * Description:      还款规则
 * Autour：          LF
 * Date：            2017/7/11 11:30
 */

public class RepaymentRuleModule extends BaseModule {
    private int daysOfYear;

//    Monthly("按月还款"),
//    BiMonthly("按双月还款"),
//    Quarterly("按季还款"),
//    HalfYearly("按半年还款"),
//    Yearly("按年还款");
    private String repaymentPeriod;

    private int dayOfRepayment;

    public int getDaysOfYear() {
        return daysOfYear;
    }

    public void setDaysOfYear(int daysOfYear) {
        this.daysOfYear = daysOfYear;
    }

    public String getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(String repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public int getDayOfRepayment() {
        return dayOfRepayment;
    }

    public void setDayOfRepayment(int dayOfRepayment) {
        this.dayOfRepayment = dayOfRepayment;
    }


}
