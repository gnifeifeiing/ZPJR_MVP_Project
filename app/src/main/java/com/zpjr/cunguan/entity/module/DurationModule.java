package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseModule;

/**
 * Description:      借款标的周期
 * Autour：          LF
 * Date：            2017/7/11 11:21
 */

public class DurationModule extends BaseModule {
    /**
     *
     */
    private static final long serialVersionUID = 8381015081513342833L;

    /**
     * 年
     */
    public int years;

    /**
     * 月
     */
    public int months;

    /**
     * 天
     */
    public int days;

    /**
     * 总月数
     */
    public int totalMonths;

    /**
     * 总天数
     */
    public int totalDays;

    public String getTotalMonth() {
        int month = 0;
        if (years > 0) {
            month += years * 12;
        }

        if (months > 0) {
            month += months;
        }
        return String.valueOf(month);
    }

    public int getTotalMonths() {
        return years * 12 + months;
    }

    public DurationModule() {}

    public DurationModule(final int years, final int months, final int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public void setTotalMonths(int totalMonths) {
        this.totalMonths = totalMonths;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "years=" + years +
                ", months=" + months +
                ", days=" + days +
                ", totalMonths=" + totalMonths +
                ", totalDays=" + totalDays +
                '}';
    }
}
