package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseModule;

/**
 * Description:      用户信息
 * Autour：          LF
 * Date：            2017/7/11 11:28
 */

public class UserModule extends BaseModule {
    /**
     *
     */
    private static final long serialVersionUID = 4848617417493351617L;

    /**
     * 用户ID
     */
    public String id;

    /**
     * 平台商户代码
     */
    public String clientCode;

    /**
     * 标记是否为企业用户  false:个人  true:企业
     */
    public boolean enterprise = false;

    /**
     * 真实姓名
     */
    public String name;

    /**
     * 登录名
     */
    public String loginName;

    /**
     * 身份证号
     */
    public String idNumber;

    /**
     * 手机号
     */
    public String mobile;

    /**
     * 邮箱
     */
    public String email;

    /**
     * 来源
     */
    public String source;

    /**
     * 平台员工ID
     */
    public String employeeId;

    /**
     * 上次修改时间
     */
    public String lastModifiedBy;

    /**
     * 上次登录日期
     */
    public String lastLoginDate;

    /**
     * 注册日期
     */
    public String registerDate;

    /**
     * 是否启用
     */
    public boolean enabled;

    /**
     * 手势密码
     */
    public String gestureCode;

    /**
     * 启用手势密码
     */
    public boolean gestureEable=false;

    private String groupId;

    @Deprecated
    public String token;
    public long now;
    private String userLevel;

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public void reset() {
        this.id = "";
        this.clientCode = "";
        this.name = "";
        this.loginName = "";
        this.idNumber = "";
        this.mobile = "";
        this.email = "";
        this.source = "";
        this.employeeId = "";
        this.lastModifiedBy = null;
        this.lastLoginDate = null;
        this.enabled = true;
        this.gestureCode = "";
        this.gestureEable = false;
        this.token = "";
        this.now = 0;
        this.enterprise = false;
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

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getGestureCode() {
        return gestureCode;
    }

    public void setGestureCode(String gestureCode) {
        this.gestureCode = gestureCode;
    }

    public boolean isGestureEable() {
        return gestureEable;
    }

    public void setGestureEable(boolean gestureEable) {
        this.gestureEable = gestureEable;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

}
