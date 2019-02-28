package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseModule;

/**
 * Description:      银行账户
 * Autour：          LF
 * Date：            2017/8/21 16:37
 */

public class BankAccountModule extends BaseModule{

    private static final long serialVersionUID = -2887229257406845848L;

    /**
     * 账户名
     */
    private String name;

    /**
     * 银行类型
     */
    private String bank;

    /**
     * 开户行地址
     */
    private String location;

    /**
     * 支行名称
     */
    private String branch;

    /**
     * 账户卡号
     */
    private String account;

    private String bankMobile;



    public String getBankMobile() {
        return bankMobile;
    }

    public void setBankMobile(String bankMobile) {
        this.bankMobile = bankMobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
