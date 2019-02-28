package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseModule;

import java.io.Serializable;

/**
 * Description:      获取用户信息
 * Autour：          LF
 * Date：            2017/8/21 15:59
 */

public class UserMessageResponseModule extends BaseModule {

    /**
     * accountName : 测试二
     * bindSerialNo : PP201703071854030010070208
     * branchNo : 103491000510
     * certNo : 410108197904227510
     * certType : ID_CARD
     * ecardNo : 6210193310200068947
     * mobile : 18937391111
     * noPwd : true
     * otherAccno : 6228480719575997110
     * otherMobile : 18937391118
     * type : EACCOUNT
     * userId : 4AB7E054-7D07-480E-9F61-200104252672
     */

    private CzAccountBean czAccount;
    /**
     * countRebate : 0
     * countRebateForMonth : 0
     * investAmount : 1000
     * investDate : 1488959088000
     * investForOne : 0
     * investTimes : 2
     * parValue : 0
     * parValueForMonth : 0
     * personal : {"children":false,"male":true}
     * rebate : {"totalAmount":0,"totalOnRebateAmount":0,"totalRebateAmount":0,"totalSuccessRebateAmount":0}
     * rebateForMonth : {"totalAmount":0,"totalOnRebateAmount":0,"totalRebateAmount":0,"totalSuccessRebateAmount":0}
     * sumRepay : 6.66
     * user : {"accountStatus":0,"clientCode":"ZPJR","email":"notavailable@creditcloud.com","enabled":true,"enterprise":false,"id":"4AB7E054-7D07-480E-9F61-200104252672","lastLoginDate":1492237275338,"loginName":"FRSM_18937391111","mobile":"18937391111","name":"爱丽丝","normal":false,"referralRewarded":false,"registerDate":1488884045000,"registryRewarded":false,"source":"WEB","status":"CREATED","userLevel":"LEVEL1"}
     * userId : 4AB7E054-7D07-480E-9F61-200104252672
     */

    private UserInfoBean userInfo;

    public CzAccountBean getCzAccount() {
        return czAccount;
    }

    public void setCzAccount(CzAccountBean czAccount) {
        this.czAccount = czAccount;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public static class CzAccountBean implements Serializable {
        @Override
        public String toString() {
            return "CzAccountBean{" +
                    "accountName='" + accountName + '\'' +
                    ", bindSerialNo='" + bindSerialNo + '\'' +
                    ", branchNo='" + branchNo + '\'' +
                    ", certNo='" + certNo + '\'' +
                    ", certType='" + certType + '\'' +
                    ", ecardNo='" + ecardNo + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", noPwd=" + noPwd +
                    ", otherAccno='" + otherAccno + '\'' +
                    ", otherMobile='" + otherMobile + '\'' +
                    ", type='" + type + '\'' +
                    ", userId='" + userId + '\'' +
                    '}';
        }

        private String accountName;
        private String bindSerialNo;
        private String branchNo;
        private String certNo;
        private String certType;
        private String ecardNo;
        private String mobile;
        private boolean noPwd;
        private String otherAccno;
        private String otherMobile;
        private String type;
        private String userId;
        private String virEcardNo;


        public String getVirEcardNo() {
            return virEcardNo;
        }

        public void setVirEcardNo(String virEcardNo) {
            this.virEcardNo = virEcardNo;
        }
        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getBindSerialNo() {
            return bindSerialNo;
        }

        public void setBindSerialNo(String bindSerialNo) {
            this.bindSerialNo = bindSerialNo;
        }

        public String getBranchNo() {
            return branchNo;
        }

        public void setBranchNo(String branchNo) {
            this.branchNo = branchNo;
        }

        public String getCertNo() {
            return certNo;
        }

        public void setCertNo(String certNo) {
            this.certNo = certNo;
        }

        public String getCertType() {
            return certType;
        }

        public void setCertType(String certType) {
            this.certType = certType;
        }

        public String getEcardNo() {
            return ecardNo;
        }

        public void setEcardNo(String ecardNo) {
            this.ecardNo = ecardNo;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public boolean isNoPwd() {
            return noPwd;
        }

        public void setNoPwd(boolean noPwd) {
            this.noPwd = noPwd;
        }

        public String getOtherAccno() {
            return otherAccno;
        }

        public void setOtherAccno(String otherAccno) {
            this.otherAccno = otherAccno;
        }

        public String getOtherMobile() {
            return otherMobile;
        }

        public void setOtherMobile(String otherMobile) {
            this.otherMobile = otherMobile;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

    }

    public static class UserInfoBean implements Serializable{
        @Override
        public String toString() {
            return "UserInfoBean{" +
                    "countRebate=" + countRebate +
                    ", countRebateForMonth=" + countRebateForMonth +
                    ", investAmount=" + investAmount +
                    ", investDate=" + investDate +
                    ", investForOne=" + investForOne +
                    ", investTimes=" + investTimes +
                    ", parValue=" + parValue +
                    ", parValueForMonth=" + parValueForMonth +
                    ", personal=" + personal +
                    ", rebate=" + rebate +
                    ", rebateForMonth=" + rebateForMonth +
                    ", sumRepay=" + sumRepay +
                    ", user=" + user +
                    ", userId='" + userId + '\'' +
                    '}';
        }

        private int countRebate;
        private int countRebateForMonth;
        private int investAmount;
        private long investDate;
        private int investForOne;
        private int investTimes;
        private int parValue;
        private int parValueForMonth;

        /**
         * children : false
         * male : true
         */

        private PersonalBean personal;
        /**
         * totalAmount : 0
         * totalOnRebateAmount : 0
         * totalRebateAmount : 0
         * totalSuccessRebateAmount : 0
         */

        private RebateBean rebate;
        /**
         * totalAmount : 0
         * totalOnRebateAmount : 0
         * totalRebateAmount : 0
         * totalSuccessRebateAmount : 0
         */

        private RebateForMonthBean rebateForMonth;
        private double sumRepay;
        /**
         * accountStatus : 0
         * clientCode : ZPJR
         * email : notavailable@creditcloud.com
         * enabled : true
         * enterprise : false
         * id : 4AB7E054-7D07-480E-9F61-200104252672
         * lastLoginDate : 1492237275338
         * loginName : FRSM_18937391111
         * mobile : 18937391111
         * name : 爱丽丝
         * normal : false
         * referralRewarded : false
         * registerDate : 1488884045000
         * registryRewarded : false
         * source : WEB
         * status : CREATED
         * userLevel : LEVEL1
         */

        private UserBean user;
        private String userId;

        public int getCountRebate() {
            return countRebate;
        }

        public void setCountRebate(int countRebate) {
            this.countRebate = countRebate;
        }

        public int getCountRebateForMonth() {
            return countRebateForMonth;
        }

        public void setCountRebateForMonth(int countRebateForMonth) {
            this.countRebateForMonth = countRebateForMonth;
        }

        public int getInvestAmount() {
            return investAmount;
        }

        public void setInvestAmount(int investAmount) {
            this.investAmount = investAmount;
        }

        public long getInvestDate() {
            return investDate;
        }

        public void setInvestDate(long investDate) {
            this.investDate = investDate;
        }

        public int getInvestForOne() {
            return investForOne;
        }

        public void setInvestForOne(int investForOne) {
            this.investForOne = investForOne;
        }

        public int getInvestTimes() {
            return investTimes;
        }

        public void setInvestTimes(int investTimes) {
            this.investTimes = investTimes;
        }

        public int getParValue() {
            return parValue;
        }

        public void setParValue(int parValue) {
            this.parValue = parValue;
        }

        public int getParValueForMonth() {
            return parValueForMonth;
        }

        public void setParValueForMonth(int parValueForMonth) {
            this.parValueForMonth = parValueForMonth;
        }

        public PersonalBean getPersonal() {
            return personal;
        }

        public void setPersonal(PersonalBean personal) {
            this.personal = personal;
        }

        public RebateBean getRebate() {
            return rebate;
        }

        public void setRebate(RebateBean rebate) {
            this.rebate = rebate;
        }

        public RebateForMonthBean getRebateForMonth() {
            return rebateForMonth;
        }

        public void setRebateForMonth(RebateForMonthBean rebateForMonth) {
            this.rebateForMonth = rebateForMonth;
        }

        public double getSumRepay() {
            return sumRepay;
        }

        public void setSumRepay(double sumRepay) {
            this.sumRepay = sumRepay;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public static class PersonalBean implements Serializable{
            @Override
            public String toString() {
                return "PersonalBean{" +
                        "children=" + children +
                        ", male=" + male +
                        '}';
            }

            private boolean children;
            private boolean male;

            public boolean isChildren() {
                return children;
            }

            public void setChildren(boolean children) {
                this.children = children;
            }

            public boolean isMale() {
                return male;
            }

            public void setMale(boolean male) {
                this.male = male;
            }
        }

        public static class RebateBean implements Serializable{
            @Override
            public String toString() {
                return "RebateBean{" +
                        "totalAmount=" + totalAmount +
                        ", totalOnRebateAmount=" + totalOnRebateAmount +
                        ", totalRebateAmount=" + totalRebateAmount +
                        ", totalSuccessRebateAmount=" + totalSuccessRebateAmount +
                        '}';
            }

            private int totalAmount;
            private double totalOnRebateAmount;
            private double totalRebateAmount;
            private double totalSuccessRebateAmount;

            public int getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(int totalAmount) {
                this.totalAmount = totalAmount;
            }

            public double getTotalOnRebateAmount() {
                return totalOnRebateAmount;
            }

            public void setTotalOnRebateAmount(double totalOnRebateAmount) {
                this.totalOnRebateAmount = totalOnRebateAmount;
            }

            public double getTotalRebateAmount() {
                return totalRebateAmount;
            }

            public void setTotalRebateAmount(double totalRebateAmount) {
                this.totalRebateAmount = totalRebateAmount;
            }

            public double getTotalSuccessRebateAmount() {
                return totalSuccessRebateAmount;
            }

            public void setTotalSuccessRebateAmount(double totalSuccessRebateAmount) {
                this.totalSuccessRebateAmount = totalSuccessRebateAmount;
            }
        }

        public static class RebateForMonthBean implements Serializable{
            @Override
            public String toString() {
                return "RebateForMonthBean{" +
                        "totalAmount=" + totalAmount +
                        ", totalOnRebateAmount=" + totalOnRebateAmount +
                        ", totalRebateAmount=" + totalRebateAmount +
                        ", totalSuccessRebateAmount=" + totalSuccessRebateAmount +
                        '}';
            }

            private int totalAmount;
            private double totalOnRebateAmount;
            private double totalRebateAmount;
            private double totalSuccessRebateAmount;

            public int getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(int totalAmount) {
                this.totalAmount = totalAmount;
            }

            public double getTotalOnRebateAmount() {
                return totalOnRebateAmount;
            }

            public void setTotalOnRebateAmount(double totalOnRebateAmount) {
                this.totalOnRebateAmount = totalOnRebateAmount;
            }

            public double getTotalRebateAmount() {
                return totalRebateAmount;
            }

            public void setTotalRebateAmount(double totalRebateAmount) {
                this.totalRebateAmount = totalRebateAmount;
            }

            public double getTotalSuccessRebateAmount() {
                return totalSuccessRebateAmount;
            }

            public void setTotalSuccessRebateAmount(double totalSuccessRebateAmount) {
                this.totalSuccessRebateAmount = totalSuccessRebateAmount;
            }
        }

        public static class UserBean implements Serializable{
            @Override
            public String toString() {
                return "UserBean{" +
                        "accountStatus=" + accountStatus +
                        ", clientCode='" + clientCode + '\'' +
                        ", email='" + email + '\'' +
                        ", enabled=" + enabled +
                        ", enterprise=" + enterprise +
                        ", id='" + id + '\'' +
                        ", lastLoginDate=" + lastLoginDate +
                        ", loginName='" + loginName + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", name='" + name + '\'' +
                        ", normal=" + normal +
                        ", referralRewarded=" + referralRewarded +
                        ", registerDate=" + registerDate +
                        ", registryRewarded=" + registryRewarded +
                        ", subscribe=" + subscribe +
                        ", source='" + source + '\'' +
                        ", status='" + status + '\'' +
                        ", userLevel='" + userLevel + '\'' +
                        '}';
            }

            private int accountStatus;
            private String clientCode;
            private String email;
            private boolean enabled;
            private boolean enterprise;
            private String id;
            private long lastLoginDate;
            private String loginName;
            private String mobile;
            private String name;
            private boolean normal;
            private boolean referralRewarded;
            private long registerDate;
            private boolean registryRewarded;
            private String source;
            private String status;
            private String userLevel;
            private int subscribe;
            /**
             * 身份证号
             */
            public String idNumber;

            public String getIdNumber() {
                return idNumber;
            }

            public void setIdNumber(String idNumber) {
                this.idNumber = idNumber;
            }

            public int getSubscribe() {
                return subscribe;
            }

            public void setSubscribe(int subscribe) {
                this.subscribe = subscribe;
            }


            public int getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(int accountStatus) {
                this.accountStatus = accountStatus;
            }

            public String getClientCode() {
                return clientCode;
            }

            public void setClientCode(String clientCode) {
                this.clientCode = clientCode;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public boolean isEnterprise() {
                return enterprise;
            }

            public void setEnterprise(boolean enterprise) {
                this.enterprise = enterprise;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public long getLastLoginDate() {
                return lastLoginDate;
            }

            public void setLastLoginDate(long lastLoginDate) {
                this.lastLoginDate = lastLoginDate;
            }

            public String getLoginName() {
                return loginName;
            }

            public void setLoginName(String loginName) {
                this.loginName = loginName;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isNormal() {
                return normal;
            }

            public void setNormal(boolean normal) {
                this.normal = normal;
            }

            public boolean isReferralRewarded() {
                return referralRewarded;
            }

            public void setReferralRewarded(boolean referralRewarded) {
                this.referralRewarded = referralRewarded;
            }

            public long getRegisterDate() {
                return registerDate;
            }

            public void setRegisterDate(long registerDate) {
                this.registerDate = registerDate;
            }

            public boolean isRegistryRewarded() {
                return registryRewarded;
            }

            public void setRegistryRewarded(boolean registryRewarded) {
                this.registryRewarded = registryRewarded;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(String userLevel) {
                this.userLevel = userLevel;
            }
        }
    }

}
