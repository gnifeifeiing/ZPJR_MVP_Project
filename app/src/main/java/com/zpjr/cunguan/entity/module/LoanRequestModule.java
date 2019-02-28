package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseModule;

/**
 * Description:      借款申请
 * Autour：          LF
 * Date：            2017/7/11 11:23
 */

public class LoanRequestModule extends BaseModule {
    private static final long serialVersionUID = 3880189518823894432L;

    /**
     * 借款标的ID
     */
    public String id;

    /**
     * 借款标的名称
     */
    public String title;

    /**
     * 借款目的
     */
    public String purpose;

    /**
     * 借款期限
     */
    public DurationModule duration;

    /**
     * 年化利率
     */
    public int rate;

    /**
     * 还款方式
     */
    public String method;

    /**
     * 借款描述
     */
    public String description;

    /**
     * 提交时间
     */
    public Long timeSubmit;

    /**
     * 借款来源
     */
    public String source;

    /**
     * 抵押物信息
     */
    public String mortgageInfo;

    /**
     * 担保信息
     */
    public String guaranteeInfo;

    /**
     * 风险措施
     */
    public String riskInfo;

    /**
     * 投资规则
     */
    public InvestRuleModule investRule;

    /**
     * 借款用户信息
     */
    public UserModule user;

    /**
     * 借款用户ID
     */
    public String userId;

    /**
     * 借款金额
     */
    public int amount;

    /**
     * 保障实体
     */
    public EntityModule guaranteeEntity;

    /**
     * 借款编号
     */
    public String serial;

    private String productKey;

    public RepaymentRuleModule repaymentRule;

    /**
     * 起息日
     */
    public long valueDate;

    /*
    *浮动利率
     */
    private int deductionRate;

    public String durationType;//标的类型

    public String minDurationDays;//最小日期

    public int floatingInterestRate;//浮动利率

    public int getFloatingInterestRate() {
        return floatingInterestRate;
    }

    public void setFloatingInterestRate(int floatingInterestRate) {
        this.floatingInterestRate = floatingInterestRate;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public String getMinDurationDays() {
        return minDurationDays;
    }

    public void setMinDurationDays(String minDurationDays) {
        this.minDurationDays = minDurationDays;
    }

    public long getValueDate() {
        return valueDate;
    }

    public void setValueDate(long valueDate) {
        this.valueDate = valueDate;
    }

    public RepaymentRuleModule getRepaymentRule() {
        return repaymentRule;
    }

    public void setRepaymentRule(RepaymentRuleModule repaymentRule) {
        this.repaymentRule = repaymentRule;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public DurationModule getDuration() {
        return duration;
    }

    public void setDuration(DurationModule duration) {
        this.duration = duration;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTimeSubmit() {
        return timeSubmit;
    }

    public void setTimeSubmit(Long timeSubmit) {
        this.timeSubmit = timeSubmit;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMortgageInfo() {
        return mortgageInfo;
    }

    public void setMortgageInfo(String mortgageInfo) {
        this.mortgageInfo = mortgageInfo;
    }

    public String getGuaranteeInfo() {
        return guaranteeInfo;
    }

    public void setGuaranteeInfo(String guaranteeInfo) {
        this.guaranteeInfo = guaranteeInfo;
    }

    public String getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(String riskInfo) {
        this.riskInfo = riskInfo;
    }

    public InvestRuleModule getInvestRule() {
        return investRule;
    }

    public void setInvestRule(InvestRuleModule investRule) {
        this.investRule = investRule;
    }

    public UserModule getUser() {
        return user;
    }

    public void setUser(UserModule user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public EntityModule getGuaranteeEntity() {
        return guaranteeEntity;
    }

    public void setGuaranteeEntity(EntityModule guaranteeEntity) {
        this.guaranteeEntity = guaranteeEntity;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getDeductionRate() {
        return deductionRate;
    }

    public void setDeductionRate(int deductionRate) {
        this.deductionRate = deductionRate;
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", purpose='" + purpose + '\'' +
                ", duration=" + duration +
                ", rate=" + rate +
                ", method='" + method + '\'' +
                ", description='" + description + '\'' +
                ", timeSubmit=" + timeSubmit +
                ", source='" + source + '\'' +
                ", mortgageInfo='" + mortgageInfo + '\'' +
                ", guaranteeInfo='" + guaranteeInfo + '\'' +
                ", riskInfo='" + riskInfo + '\'' +
                ", investRule=" + investRule +
                ", user=" + user +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", guaranteeEntity=" + guaranteeEntity +
                ", serial='" + serial + '\'' +
                ", productKey='" + productKey + '\'' +
                ", repaymentRule=" + repaymentRule +
                ", valueDate=" + valueDate +
                ", deductionRate=" + deductionRate +
                ", durationType='" + durationType + '\'' +
                ", minDurationDays='" + minDurationDays + '\'' +
                ", floatingInterestRate=" + floatingInterestRate +
                '}';
    }
}
