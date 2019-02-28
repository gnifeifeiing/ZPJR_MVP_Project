package com.zpjr.cunguan.entity.module;

/**
 * Description:      版本号
 * Autour：          LF
 * Date：            2017/8/22 9:28
 */

public class VersionModule {
    /**
     * 版本号
     */
    private int versionCode;

    /**
     * 版本名称
     */
    private String versionName;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 版本描述信息
     */
    private String description;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否强制更新
     */
    private boolean forceUpdate;

    /**
     * 更新类型 0：手动 1：自动
     */
    private int updateType;

    private String name;

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public int getUpdateType() {
        return updateType;
    }

    public void setUpdateType(int updateType) {
        this.updateType = updateType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
