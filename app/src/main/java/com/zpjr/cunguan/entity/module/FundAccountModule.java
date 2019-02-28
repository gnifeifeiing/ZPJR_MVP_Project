package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseModule;

/**
 * Description:      资金账户
 * Autour：          LF
 * Date：            2017/8/21 16:36
 */

public class FundAccountModule extends BaseModule{


    private static final long serialVersionUID = -8825708930588566995L;

    private String id;

    private String category;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 是否已经验证通过
     */
    private boolean valid;
    /**
     * 是否为首选默认银行账号,充值提现时将显示在第一个
     */
    private boolean defaultAccount;

    /**
     * 创建时间
     */
    private long timeRecorded;
    /**
     * 银行账号
     */
    private BankAccountModule account;
    private boolean expressAccount;
    /*
     * 是否删除卡
     */
    private boolean deleted;
    /**
     * 每日限额
     */
    private String dailyLimit;
    /**
     * 单笔限额
     */
    private String singleLimit;

    public void setDailyLimit(String dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public void setSingleLimit(String singleLimit) {
        this.singleLimit = singleLimit;
    }

    public String getSingleLimit() {
        return singleLimit;
    }

    public String getDailyLimit() {
        return dailyLimit;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isExpressAccount() {
        return expressAccount;
    }

    public void setExpressAccount(boolean expressAccount) {
        this.expressAccount = expressAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(boolean defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    public long getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(long timeRecorded) {
        this.timeRecorded = timeRecorded;
    }

    public BankAccountModule getAccount() {
        return account;
    }

    public void setAccount(BankAccountModule account) {
        this.account = account;
    }
}
