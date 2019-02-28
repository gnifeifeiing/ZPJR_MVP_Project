package com.zpjr.cunguan.common.utils;

import java.io.Serializable;

/**
 * 作者：WD on 2017/2/24 10:08
 * 邮箱：pmccwd@mrteam.cn
 */
public class ExpireDuration implements Serializable {
    @Override
    public String toString() {
        return "ExpireDuration{" +
                "days=" + days +
                ", months=" + months +
                ", showDuration='" + showDuration + '\'' +
                ", totalDays=" + totalDays +
                ", totalMonths=" + totalMonths +
                ", years=" + years +
                '}';
    }

    /**
     * days : 30
     * months : 1
     * showDuration : 1个月零30天
     * totalDays : 60
     * totalMonths : 1
     * years : 0
     */

    private int days;
    private int months;
    private String showDuration;
    private int totalDays;
    private int totalMonths;
    private int years;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public String getShowDuration() {
        return showDuration;
    }

    public void setShowDuration(String showDuration) {
        this.showDuration = showDuration;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getTotalMonths() {
        return totalMonths;
    }

    public void setTotalMonths(int totalMonths) {
        this.totalMonths = totalMonths;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
