package com.zpjr.cunguan.common.utils;

import android.content.Context;

import com.zpjr.cunguan.R;

public class StatusString {

    public static String getCouDisplayName(CouponPackage pack) {
        String type = pack.getType();
        String displayName = "未知奖券类型";
        if (type.equals("PRINCIPAL")) {
            displayName = pack.getFriendlyParValue() + "增值券";
        }
        if (type.equals("REBATE")) {
            displayName = pack.getFriendlyParValue() + "返现券";
        }
        if (type.equals("INTEREST")) {
            displayName = pack.getFriendlyParValue() + "加息券";
        }
        if (type.equals("CASH")) {
            displayName = pack.getFriendlyParValue() + "现金券";
        }
        return displayName;
    }

    public static String getCouDisplayName(String type) {

        String displayName = "未知奖券类型";
        if (type.equals("PRINCIPAL")) {
            displayName = "增值券";
        }
        if (type.equals("REBATE")) {
            displayName = "返现券";
        }
        if (type.equals("INTEREST")) {
            displayName = "加息券";
        }
        if (type.equals("CASH")) {
            displayName = "现金券";
        }
        return displayName;
    }

    public static String getCouDisplayTypeName(String type) {

        String displayName = "未知奖券包";
        if (type.equals("PRINCIPAL")) {
            displayName = "投资增值包";
        }
        if (type.equals("REBATE")) {
            displayName = "投资返现包";
        }
        if (type.equals("INTEREST")) {
            displayName = "投资奖券包";
        }
        if (type.equals("CASH")) {
            displayName = "现金奖券包";
        }
        return displayName;
    }

    public static String getRepaymentMode(String mode) {
        String modeString = "";
        if (mode.equals("YearlyInterest")) {
            modeString = "按年付息到期还本";
        }
        if (mode.equals("MonthlyInterest")) {
            modeString = "按月付息到期还本";
        }
        if (mode.equals("EqualInstallment")) {
            modeString = "按月等额本息";
        }
        if (mode.equals("EqualPrincipal")) {
            modeString = "按月等额本金";
        }
        if (mode.equals("BulletRepayment")) {
            modeString = "一次性还本付息";
        }
        if (mode.equals("EqualInterest")) {
            modeString = "按月平息";
        }
        return modeString;
    }


    public static String getTouziStatus(String status) {
        String statusString = "已完成";
        if (status.equals("OPENED")) {
            statusString = "立即投资";
        }
        if (status.equals("FINISHED")) {
            statusString = "已满标";
        }
        if (status.equals("SETTLED")) {
            statusString = "还款中";
        }
        if (status.equals("CLEARED")) {
            statusString = "还款结束";
        }
        // if (status.equals("OVERDUE")) {
        // statusString = "逾期未归还";
        // }
        // if (status.equals("BREACH")) {
        // statusString = "贷款违约";
        // }
        // if (status.equals("ARCHIVED")) {
        // statusString = "已存档";
        // }
        if (status.equals("SCHEDULED")) {
            statusString = "即将开始";
        }
        return statusString;
    }

    public static String getMyTouziStatus(String status) {
        String statusString = "已完成";
        if (status.equals("OPENED")) {
            statusString = "立即投资";
        }
        if (status.equals("FINISHED")) {
            statusString = "已满标";
        }
        if (status.equals("SETTLED")) {
            statusString = "计息中";
        }
        if (status.equals("CLEARED")) {
            statusString = "已还清";
        }
        if (status.equals("OVERDUE")) {
            statusString = "逾期";
        }
        if (status.equals("BREACH")) {
            statusString = "违约";
        }
        if (status.equals("ARCHIVED")) {
            statusString = "已存档";
        }
        if (status.equals("SCHEDULED")) {
            statusString = "即将开始";
        }
        if (status.equals("FROZEN")) {
            statusString = "募集中";
        }
        if (status.equals("PROPOSED")) {
            statusString = "申请中";
        }
        return statusString;
    }

    public static String getOperationName(String operation) {
        String operationString = "";
        switch (operation) {
            case "DEPOSIT":
                operationString = "充值";
                break;
            case "WITHDRAW":
                operationString = "提现";
                break;
            case "INVEST":
                operationString = "投标";
                break;
            case "INVEST_REPAY":
                operationString = "回款";
                break;
            case "FEE_WITHDRAW":
                operationString = "提现手续费";
                break;
            case "TRANSFER":
                operationString = "平台奖励";
                break;
            case "OFFLINE_DEPOSIT":
                operationString = "线下充值";
                break;
            case "BALANCE_TRANSFER":
                operationString = "大额转账";
                break;
            default:
                break;
        }
        return operationString;
    }

    public static String getOperationSign(String operation) {
        String signString = "";
        switch (operation) {
            case "DEPOSIT":
                signString = "+";//充值";
                break;
            case "WITHDRAW":
                signString = "-";//提现";
                break;
            case "FEE_WITHDRAW":
                signString = "-";
                break;
            case "INVEST":
                signString = "";//投标";
                break;
            case "TRANSFER":
                signString = "+";
                break;
            default:
                break;
        }
        return signString;
    }

    public static String getOperationType(String type) {
        String typeStrng = "";
        switch (type) {
            case "IN":
                typeStrng = "资金转入";
                break;
            case "OUT":
                typeStrng = "资金转出";
                break;
            case "RELEASE":
                typeStrng = "解冻";
                break;
            case "FREEZE":
                typeStrng = "冻结";
                break;
            default:
                break;
        }
        return typeStrng;
    }

    public static String getOperationStatus(String status) {
        String statusStrng = "";
        switch (status) {
            case "PROCESSING":
                statusStrng = "处理中";
                break;
            case "SUCCESSFUL":
                statusStrng = "成功";
                break;
            case "REJECTED":
                statusStrng = "拒绝";
                break;
            case "AUDITING":
                statusStrng = "审核中";
                break;
            case "INITIALIZED":
                statusStrng = "初始";
                break;
            case "FAILED":
                statusStrng = "失败";
                break;
            case "CANCELED":
                statusStrng = "取消";
                break;
            default:
                break;
        }
        return statusStrng;
    }

    public static String getRepaymentStatus(String status) {
        String statusStrng = "";
        switch (status) {
            case "UNDUE":
                statusStrng = "未到期";
                break;
            case "DUE":
                statusStrng = "已到期";
                break;
            case "REPAYED":
                statusStrng = "还款完成";
                break;
            case "OVERDUE":
                statusStrng = "逾期";
                break;
            default:
                break;
        }
        return statusStrng;
    }

    public static String getIntegralStatus(String status) {
        String statusStrng = "";
        switch (status) {
            case "VALID":
                statusStrng = "成功";
                break;
            case "INVALID":
                statusStrng = "失败";
                break;
            case "TEST":
                statusStrng = "Test";
                break;
            default:
                break;
        }
        return statusStrng;
    }
//	08-28 02:20:06.339: E/-----JSON----(16487): {"HXB":"华夏银行","GDB":"广发银行","CITIC":"中信银行","CCB":"建设银行","PAB":"平安银行","CIB":"兴业银行","ABC":"农业银行","CMBC":"民生银行","CMB":"招商银行","SPDB":"浦发银行","ICBC":"工商银行","CEB":"光大银行","PSBC":"中国邮政储蓄银行","BOC":"中国银行"}

    public static String getBankName(String acronym) {
        String bankName = acronym;
        if (acronym.equals("ICBC")) {
            bankName = "中国工商银行";
        }
        if (acronym.equals("ABC")) {
            bankName = "中国农业银行";
        }
        if (acronym.equals("CCB")) {
            bankName = "中国建设银行";
        }
        if (acronym.equals("BOC")) {
            bankName = "中国银行";
        }
        if (acronym.equals("CEB")) {
            bankName = "中国光大银行";
        }
        if (acronym.equals("CIB")) {
            bankName = "兴业银行";
        }
        if (acronym.equals("CITIC")) {
            bankName = "中信银行";
        }
        if (acronym.equals("PAB")) {
            bankName = "平安银行";
        }
        if (acronym.equals("CMB")) {
            bankName = "招商银行";
        }
        if (acronym.equals("BOCOM")) {
            bankName = "交通银行";
        }
        if (acronym.equals("PSBC")) {
            bankName = "中国邮政储蓄银行";
        }
        if (acronym.equals("SPDB")) {
            bankName = "上海浦东发展银行";
        }
        if (acronym.equals("GDB")) {
            bankName = "广发银行";
        }
        if (acronym.equals("HXB")) {
            bankName = "华夏银行";
        }
        if(acronym.equals("HSB")){
            bankName = "徽商银行";
        }
        if (acronym.equals("CBHB")) {
            bankName = "渤海银行";
        }
        if (acronym.equals("EGB")) {
            bankName = "恒丰银行";
        }
        if (acronym.equals("CZBANK")) {
            bankName = "浙商银行";
        }

        /**
         * 未用到的银行
         */
        if (acronym.equals("BEA")) {
            bankName = "东亚银行";
        }
        if (acronym.equals("CMBC")) {
            bankName = "中国民生银行";
        }
        if (acronym.equals("BOS")) {
            bankName = "上海银行";
        }
        if (acronym.equals("BCCB")) {
            bankName = "北京银行";
        }
        if (acronym.equals("HZCB")) {
            bankName = "杭州银行";
        }
        if (acronym.equals("NJCB")) {
            bankName = "南京银行";
        }
        if (acronym.equals("SRCB")) {
            bankName = "上海农村商业银行";
        }
        if (acronym.equals("MTBANK")) {
            bankName = "浙江民泰商业银行";
        }
        if (acronym.equals("ZJTLCB")) {
            bankName = "浙江泰隆商业银行";
        }
        if (acronym.equals("BJRCB")) {
            bankName = "北京农商银行";
        }
        if (acronym.equals("SZCRU")) {
            bankName = "深圳农商银行";
        }
        if(acronym.equals("LZB")){
            bankName = "兰州银行 ";
        }
        if(acronym.equals("SDB")){
            bankName = "深发展银行";
        }
        if(acronym.equals("BHB")){
            bankName = "河北银行";
        }
        return bankName;
    }

    public static String getAcronym(String bankName) {
        String acronym = bankName;
        if (bankName.equals("东亚银行")) {
            acronym = "BEA";
        }
        if (bankName.equals("中国民生银行")) {
            acronym = "CMBC";
        }
        if (bankName.equals("中国农业银行")) {
            acronym = "ABC";
        }
        if (bankName.equals("招商银行")) {
            acronym = "CMB";
        }
        if (bankName.equals("华夏银行")) {
            acronym = "HXB";
        }
        if (bankName.equals("上海浦东发展银行")) {
            acronym = "SPDB";
        }
        if (bankName.equals("中信银行")) {
            acronym = "CITIC";
        }
        if (bankName.equals("中国光大银行")) {
            acronym = "CEB";
        }
        if (bankName.equals("平安银行")) {
            acronym = "PAB";
        }
        if (bankName.equals("兴业银行")) {
            acronym = "CIB";
        }
        if (bankName.equals("中国邮政储蓄银行")) {
            acronym = "PSBC";
        }
        if (bankName.equals("交通银行")) {
            acronym = "BOCOM";
        }
        if (bankName.equals("中国建设银行")) {
            acronym = "CCB";
        }
        if (bankName.equals("中国工商银行")) {
            acronym = "ICBC";
        }
        if (bankName.equals("渤海银行")) {
            acronym = "CBHB";
        }
        if (bankName.equals("上海银行")) {
            acronym = "BOS";
        }
        if (bankName.equals("中国银行")) {
            acronym = "BOC";
        }
        if (bankName.equals("北京银行")) {
            acronym = "BCCB";
        }
        if (bankName.equals("杭州银行")) {
            acronym = "HZCB";
        }
        if (bankName.equals("南京银行")) {
            acronym = "NJCB";
        }
        if (bankName.equals("北京农商银行")) {
            acronym = "BJRCB";
        }
        if (bankName.equals("广发银行")) {
            acronym = "GDB";
        }
        if (bankName.equals("浙商银行")) {
            acronym = "CZB";
        }
        if (bankName.equals("上海农村银行")) {
            acronym = "SRCB";
        }
        if (bankName.equals("深圳发展银行")) {
            acronym = "SZCRU";
        }
        if (bankName.equals("浙江民泰商业银行")) {
            acronym = "MTBANK";
        }
        if (bankName.equals("浙江泰隆商业银行")) {
            acronym = "ZJTLCB";
        }
        if(bankName.equals("兰州银行 ")){
            acronym = "LZB";
        }
        if(bankName.equals("徽商银行")){
            acronym = "HSB";
        }
        if(bankName.equals("深发展银行")){
            acronym = "SDB";
        }
        if(bankName.equals("河北银行")){
            acronym = "BHB";
        }

        return bankName;
    }

    public static int getBankIconResId(Context context, String acronym) {
        int resId = 0;
        if (acronym.equals("CZBANK")) {
            resId = R.mipmap.czsb;
        }
        if (acronym.equals("EGB")) {
            resId = R.mipmap.egb;
        }
        if (acronym.equals("BEA")) {
            resId = R.mipmap.img_bea;
        }
        if (acronym.equals("CMBC")) {
            resId = R.mipmap.img_cmbc;
        }
        if (acronym.equals("ABC")) {
            resId = R.mipmap.abc;
        }
        if (acronym.equals("CMB")) {
            resId = R.mipmap.cmb;
        }
        if (acronym.equals("HXB")) {
            resId = R.mipmap.img_hxb;
        }
        if (acronym.equals("SPDB")) {
            resId = R.mipmap.spd;
        }
        if (acronym.equals("CITIC")) {
            resId = R.mipmap.citic;
        }
        if (acronym.equals("CEB")) {
            resId = R.mipmap.ceb;
        }
        if (acronym.equals("PAB")) {
            resId = R.mipmap.pab;
        }
        if (acronym.equals("CIB")) {
            resId = R.mipmap.ltd;
        }
        if (acronym.equals("PSBC")) {
            resId = R.mipmap.psb;
        }
        if (acronym.equals("BOCOM")) {
            resId = R.mipmap.boc;
        }
        if (acronym.equals("CCB")) {
            resId = R.mipmap.ccb;
        }
        if (acronym.equals("ICBC")) {
            resId = R.mipmap.iac;
        }
        if (acronym.equals("CBHB")) {
            resId = R.mipmap.bhb;
        }
        if (acronym.equals("BOS")) {
            resId = R.mipmap.shb;
        }
        if (acronym.equals("BOC")) {
            resId = R.mipmap.boc;
        }
        if (acronym.equals("BCCB")) {
            resId = R.mipmap.bob;
        }
        if (acronym.equals("HZCB")) {
            resId = R.mipmap.hzcb;
        }
        if (acronym.equals("NJCB")) {
            resId = R.mipmap.bonj;
        }
        if (acronym.equals("GDB")) {
            resId = R.mipmap.cgb;
        }
        if (acronym.equals("CZB")) {
            resId = R.mipmap.czsb;
        }
        if (acronym.equals("SRCB")) {
            resId = R.mipmap.srcb;
        }
        if (acronym.equals("MTBANK")) {
            resId = R.mipmap.zjmtcb;
        }
        if (acronym.equals("ZJTLCB")) {
            resId = R.mipmap.zjtlcb;
        }
        if (acronym.equals("BJRCB")) {
            resId = R.mipmap.brcb;
        }
        if (acronym.equals("SZCRU")) {
            resId = R.mipmap.szdb;
        }
        if(acronym.equals("LZB")){
            resId = R.mipmap.lzb;
        }
        if(acronym.equals("HSB")){
            resId = R.mipmap.hsb;
        }
        if(acronym.equals("SDB")){
            resId = R.mipmap.sfb;
        }
        if(acronym.equals("BHB")){
            resId = R.mipmap.hbb;
        }
        return resId;
    }

    public static String getMoneyLabel(String acronym) {
        String label = "";
        if (acronym.equals("INVEST")) {
            label = "投标";
        }
        if (acronym.equals("WITHDRAW")) {
            label = "取现";
        }
        if (acronym.equals("DEPOSIT")) {
            label = "充值";
        }
        if (acronym.equals("LOAN")) {
            label = "放款";
        }
        if (acronym.equals("LOAN_REPAY")) {
            label = "贷款还款";
        }
        if (acronym.equals("DISBURSE")) {
            label = "垫付还款";
        }
        if (acronym.equals("INVEST_REPAY")) {
            label = "投资还款";
        }
        if (acronym.equals("CREDIT_ASSIGN")) {
            label = "债权转让";
        }
        if (acronym.equals("TRANSFER")) {
            label = "转账扣款";
        }
        if (acronym.equals("REWARD_REGISTER")) {
            label = "注册奖励";
        }
        if (acronym.equals("REWARD_INVEST")) {
            label = "投标奖励";
        }
        if (acronym.equals("REWARD_DEPOSIT")) {
            label = "充值奖励";
        }
        if (acronym.equals("FEE_WITHDRAW")) {
            label = "提现手续费";
        }
        if (acronym.equals("FEE_AUTHENTICATE")) {
            label = "身份验证手续费";
        }
        if (acronym.equals("FEE_INVEST_INTEREST")) {
            label = "汇款利息管理费";
        }
        if (acronym.equals("FEE_LOAN_SERVICE")) {
            label = "借款服务费";
        }
        if (acronym.equals("FEE_LOAN_MANAGE")) {
            label = "借款管理费";
        }
        if (acronym.equals("FEE_LOAN_INTEREST")) {
            label = "还款利息管理费";
        }
        if (acronym.equals("FEE_LOAN_VISIT")) {
            label = "实地考察费";
        }
        if (acronym.equals("FEE_LOAN_GUARANTEE")) {
            label = "担保费";
        }
        if (acronym.equals("FEE_LOAN_RISK")) {
            label = "风险管理费";
        }
        if (acronym.equals("FEE_LOAN_OVERDUE")) {
            label = "逾期管理费";
        }
        if (acronym.equals("FEE_LOAN_PENALTY")) {
            label = "逾期罚息";
        }
        if (acronym.equals("FEE_LOAN_PENALTY_INVEST")) {
            label = "逾期罚息";
        }
        if (acronym.equals("FEE_DEPOSIT")) {
            label = "充值手续费";
        }
        if (acronym.equals("FEE_ADVANCE_REPAY")) {
            label = "提前还款违约金";
        }
        if (acronym.equals("FEE_ADVANCE_REPAY_INVEST")) {
            label = "提前还款违约金";
        }
        if (acronym.equals("FSS")) {
            label = "生利宝";
        }
        return label;

    }

    public static int getCiAmount(String acronym) {
        int resId = 5000;
		if (acronym.equals("HSB")){//微商银行
            resId =10000000;
        }
        if (acronym.equals("CBHB")){//渤海银行
            resId =1000000;
        }
        if (acronym.equals("EGB")){//渤海银行
            resId =1000000;
        }
        if (acronym.equals("ICBC")) {//中国工商银行 充值最高限额：单笔5万元，每日5万元
            resId = 50000;
        }
        if (acronym.equals("ABC")) {//中国农业银行 充值最高限额：单笔5万元，每日2万元。
            resId = 200000;
        }
        if (acronym.equals("CCB")) {//中国建设银行 充值最高限额：单笔5万元。
            resId = 200000;
        }
        if (acronym.equals("BOC")) {//中国银行 充值最高限额：单笔5万元，每日20万元
            resId = 50000;
        }
        if (acronym.equals("CEB")) {//光大银行 充值最高限额：单笔5万元，每日100万元。
            resId = 10000000;
        }
        if (acronym.equals("CIB")) {//兴业银行 充值最高限额：单笔5万元，每日5万元。
            resId = 50000;
        }
        if (acronym.equals("CITIC")) {//中信银行 充值最高限额：单笔5万元，每日100万元。
            resId = 50000;
        }
        if (acronym.equals("PAB")) {//平安银行  充值最高限额：单笔5万元，每日100万元
            resId = 100000;
        }
        if (acronym.equals("BOCOM")) {//交通银行  充值最高限额：单笔5万元，每日20万元。
            resId = 20000;
        }
        if (acronym.equals("SPDB")) {//浦发银行 充值最高限额：单笔5万元，每日5万元。
            resId = 50000;
        }
        if (acronym.equals("GDB")) {//广发银行 充值最高限额：单笔50万元。
            resId = 500000;
        }
        if (acronym.equals("CMBC")) {//民生银行 充值最高限额：单笔50万元，每日100万元
            resId = 500000;
        }
        if (acronym.equals("HXB")) {//华夏银行 充值最高限额：单笔5万元，每日100万元。
            resId = 50000;
        }
        if (acronym.equals("CMB")) {//招商银行 充值最高限额：单笔0.1万元，每日1万元。
            resId = 1000;
        }
        if (acronym.equals("CBHB")) {//
            resId = 500000;
        }
        if (acronym.equals("BOS")) {//
            resId = 5000;
        }
        if (acronym.equals("PINGAN")) {//平安银行 充值最高限额：单笔5万元，每日100万元。
            resId = 50000;
        }
        return resId;
    }

    public static int getDayAmount(String acronym) {
        int resId = 10000;
        if (acronym.equals("HSB")){//微商银行
            resId =10000000;
        }
        if (acronym.equals("CBHB")){//渤海银行
            resId =10000000;
        }
        if (acronym.equals("EGB")){//恒丰银行
            resId =1000000;
        }
        if (acronym.equals("ICBC")) {//中国工商银行 充值最高限额：单笔5万元，每日5万元
            resId = 50000;
        }
        if (acronym.equals("ABC")) {//中国农业银行 充值最高限额：单笔5万元，每日2万元。
            resId = 500000;
        }
        if (acronym.equals("CCB")) {//中国建设银行 充值最高限额：单笔5万元。
            resId = 500000;
        }
        if (acronym.equals("BOC")) {//中国银行 充值最高限额：单笔5万元，每日20万元
            resId = 10000000;
        }
        if (acronym.equals("CEB")) {//光大银行 充值最高限额：单笔5万元，每日100万元。
            resId = 30000000;
        }
        if (acronym.equals("CIB")) {//兴业银行 充值最高限额：单笔5万元，每日5万元。
            resId = 50000;
        }
        if (acronym.equals("CITIC")) {//中信银行 充值最高限额：单笔5万元，每日100万元。
            resId = 1000000000;
        }
        if (acronym.equals("PAB")) {//平安银行  充值最高限额：单笔5万元，每日100万元
            resId = 1000000;
        }
        if (acronym.equals("BOCOM")) {//交通银行  充值最高限额：单笔5万元，每日20万元。
            resId = 20000;
        }
        if (acronym.equals("SPDB")) {//浦发银行 充值最高限额：单笔5万元，每日5万元。
            resId = 50000;
        }
        if (acronym.equals("GDB")) {//广发银行 充值最高限额：单笔50万元。
            resId = 1000000;
        }
        if (acronym.equals("CMBC")) {//民生银行 充值最高限额：单笔50万元，每日100万元
            resId = 300000000;
        }
        if (acronym.equals("HXB")) {//华夏银行 充值最高限额：单笔5万元，每日100万元。
            resId = 50000;
        }
        return resId;
    }
}
