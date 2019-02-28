package com.zpjr.cunguan.common.utils;

import android.support.annotation.Nullable;

import java.io.Serializable;

public class CouponPackage implements Serializable {
	@Override
	public String toString() {
		return "CouponPackage{" +
				"id='" + id + '\'' +
				", type='" + type + '\'' +
				", name='" + name + '\'' +
				", displayName='" + displayName + '\'' +
				", code='" + code + '\'' +
				", userEventType='" + userEventType + '\'' +
				", description='" + description + '\'' +
				", totalCount=" + totalCount +
				", parValue=" + parValue +
				", issuer=" + issuer +
				", timeIssued=" + timeIssued +
				", timeStart=" + timeStart +
				", timeExpire=" + timeExpire +
				", minimumInvest=" + minimumInvest +
				", expireDuration=" + expireDuration +
				", minimumDuration=" + minimumDuration +
				", maximumDuration=" + maximumDuration +
				", durationRule='" + durationRule + '\'' +
				", friendlyParValue='" + friendlyParValue + '\'' +
				'}';
	}

	private String id;

	private String type;

	private String name;

	private String displayName;

	private String code;

	private String userEventType;

	private String description;

	private int totalCount;

	/**
	 * 金额 是加息券要除以100
	 */
	private float parValue;

	private Owner issuer;

	private long timeIssued;

	@Nullable
	private long timeStart;

	@Nullable
	private long timeExpire;

	private float minimumInvest;

	private ExpireDuration expireDuration;

	/**
	 * 投资最小期限
	 */
	private int minimumDuration;

	/**
	 * 投资最大期限
	 */
	private int maximumDuration;

	/**
	 * 月份限制友情提示
	 */
	private String durationRule;

	/**
	 * 金额限制友情提示
	 */
	private String friendlyParValue;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserEventType() {
		return userEventType;
	}

	public void setUserEventType(String userEventType) {
		this.userEventType = userEventType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public float getParValue() {
		return parValue;
	}

	public void setParValue(float parValue) {
		this.parValue = parValue;
	}

	public Owner getIssuer() {
		return issuer;
	}

	public void setIssuer(Owner issuer) {
		this.issuer = issuer;
	}

	public long getTimeIssued() {
		return timeIssued;
	}

	public void setTimeIssued(long timeIssued) {
		this.timeIssued = timeIssued;
	}

	public long getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(long timeStart) {
		this.timeStart = timeStart;
	}

	public long getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(long timeExpire) {
		this.timeExpire = timeExpire;
	}

	public float getMinimumInvest() {
		return minimumInvest;
	}

	public void setMinimumInvest(float minimumInvest) {
		this.minimumInvest = minimumInvest;
	}

	public int getMinimumDuration() {
		return minimumDuration;
	}

	public void setMinimumDuration(int minimumDuration) {
		this.minimumDuration = minimumDuration;
	}

	public int getMaximumDuration() {
		return maximumDuration;
	}

	public void setMaximumDuration(int maximumDuration) {
		this.maximumDuration = maximumDuration;
	}

	public String getDurationRule() {
		return durationRule;
	}

	public void setDurationRule(String durationRule) {
		this.durationRule = durationRule;
	}

	public String getFriendlyParValue() {
		return friendlyParValue;
	}

	public void setFriendlyParValue(String friendlyParValue) {
		this.friendlyParValue = friendlyParValue;
	}
	public void setExpireDuration(ExpireDuration expireDuration) {
		this.expireDuration = expireDuration;
	}

	public ExpireDuration getExpireDuration() {
		return expireDuration;
	}
}
