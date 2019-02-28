package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseModule;

import java.math.BigDecimal;

/**
 * Description:      标的基本信息
 * Autour：          LF
 * Date：            2017/7/11 11:19
 */

public class LoanModule extends BaseModule {
    /**
     *
     */
//	private static final long serialVersionUID = 725673078345496633L;

    /**
     * 标的ID
     */
    public String id;

    /**
     * 标的编号
     */
    public String serial;

    /**
     * 标的名称
     */
    public String title;

    /**
     * 还款方式（见RepaymentMethod）
     */
    public String method;

    /**
     * 序号
     */
    public String ordinal;

    /**
     * 金额
     */
    public BigDecimal amount;

    /**
     * 年化利率 （12.3% 取值为1230）
     */
    public int rate;

    /**
     * 标的期限
     */
    public DurationModule duration;

    /**
     * 借款申请
     */
    public LoanRequestModule loanRequest;

    /**
     * 开标时间
     */
    public Long timeOpen;

    /**
     * 满标时间
     */
    public Long timeFinished;

    /**
     * 还款完成时间
     */
    public Long timeCleared;

    /**
     * 结算时间
     */
    public Long timeSettled;

    /**
     * 有无抵押
     */
    public boolean mortgaged;

    /**
     * 当前已投标数
     */
    public long bidNumber;

    /**
     * 当前已投标金额
     */
    public BigDecimal bidAmount;

    /**
     * 剩余金额
     */
    public BigDecimal available;

    /**
     * 标的状态（见LoanStatus）
     */
    public String status;

    /**
     * 标的已投资金额
     */
    public BigDecimal investAmount;

    /**
     * 标的投资比例（依此为基础计算其他已投资参数）
     */
    public double investPercent;

    /**
     * 待发布标的剩余时间（自行计算）
     */
    @Deprecated
    public long timeLoss = -1;

    @Deprecated
    public long tickLoss = 0;

    @Deprecated
    public double balance;

    @Deprecated
    public long leftBidTime = 0;

    @Deprecated
    public long timeLeft = 0;

    @Deprecated
    public long countDownTime = 0;

    @Deprecated
    public long deviation = 0;

    /**
     * 筹款周期（单位小时）
     */
    public long timeout;

    /**
     * 借款企业名称
     */
    public String corporationName;

    /**
     * 借款企业简称
     */
    public String corporationShortName;

    /**
     * 借款风险评级
     */
    public String riskGrade;

    /**
     * 标的位置信息
     */
    public String location;

    /**
     * 借款企业类型
     */
    public String industry;

    /**
     * 借款合同编号
     */
    public String contractCode;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(String ordinal) {
        this.ordinal = ordinal;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public DurationModule getDuration() {
        return duration;
    }

    public void setDuration(DurationModule duration) {
        this.duration = duration;
    }

    public LoanRequestModule getLoanRequest() {
        return loanRequest;
    }

    public void setLoanRequest(LoanRequestModule loanRequest) {
        this.loanRequest = loanRequest;
    }

    public Long getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(Long timeOpen) {
        this.timeOpen = timeOpen;
    }

    public Long getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(Long timeFinished) {
        this.timeFinished = timeFinished;
    }

    public Long getTimeCleared() {
        return timeCleared;
    }

    public void setTimeCleared(Long timeCleared) {
        this.timeCleared = timeCleared;
    }

    public Long getTimeSettled() {
        return timeSettled;
    }

    public void setTimeSettled(Long timeSettled) {
        this.timeSettled = timeSettled;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    public long getBidNumber() {
        return bidNumber;
    }

    public void setBidNumber(long bidNumber) {
        this.bidNumber = bidNumber;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public double getInvestPercent() {
        return investPercent*100;
    }

    public BigDecimal getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount = investAmount;
    }

    public void setInvestPercent(double investPercent) {
        this.investPercent = investPercent;
    }

    public long getTimeLoss() {
        return timeLoss;
    }

    public void setTimeLoss(long timeLoss) {
        this.timeLoss = timeLoss;
    }

    public long getTickLoss() {
        return tickLoss;
    }

    public void setTickLoss(long tickLoss) {
        this.tickLoss = tickLoss;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getLeftBidTime() {
        return leftBidTime;
    }

    public void setLeftBidTime(long leftBidTime) {
        this.leftBidTime = leftBidTime;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public long getCountDownTime() {
        return countDownTime;
    }

    public void setCountDownTime(long countDownTime) {
        this.countDownTime = countDownTime;
    }

    public long getDeviation() {
        return deviation;
    }

    public void setDeviation(long deviation) {
        this.deviation = deviation;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public String getCorporationShortName() {
        return corporationShortName;
    }

    public void setCorporationShortName(String corporationShortName) {
        this.corporationShortName = corporationShortName;
    }

    public String getRiskGrade() {
        return riskGrade;
    }

    public void setRiskGrade(String riskGrade) {
        this.riskGrade = riskGrade;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", serial='" + serial + '\'' +
                ", title='" + title + '\'' +
                ", method='" + method + '\'' +
                ", ordinal='" + ordinal + '\'' +
                ", amount=" + amount +
                ", rate=" + rate +
                ", duration=" + duration +
                ", loanRequest=" + loanRequest +
                ", timeOpen=" + timeOpen +
                ", timeFinished=" + timeFinished +
                ", timeCleared=" + timeCleared +
                ", timeSettled=" + timeSettled +
                ", mortgaged=" + mortgaged +
                ", bidNumber=" + bidNumber +
                ", bidAmount=" + bidAmount +
                ", available=" + available +
                ", status='" + status + '\'' +
                ", investAmount=" + investAmount +
                ", investPercent=" + investPercent +
                ", timeLoss=" + timeLoss +
                ", tickLoss=" + tickLoss +
                ", balance=" + balance +
                ", leftBidTime=" + leftBidTime +
                ", timeLeft=" + timeLeft +
                ", countDownTime=" + countDownTime +
                ", deviation=" + deviation +
                ", timeout=" + timeout +
                ", corporationName='" + corporationName + '\'' +
                ", corporationShortName='" + corporationShortName + '\'' +
                ", riskGrade='" + riskGrade + '\'' +
                ", location='" + location + '\'' +
                ", industry='" + industry + '\'' +
                ", contractCode='" + contractCode + '\'' +
                '}';
    }
}
