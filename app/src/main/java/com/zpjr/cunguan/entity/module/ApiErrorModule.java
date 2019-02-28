package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.common.base.BaseModule;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/19 14:45
 */

public class ApiErrorModule extends BaseModule {
    /**
     * 错误消息码
     */
    public String message;

    /**
     * 错误字段
     */
    public String type;

    /**
     * 错误字段值
     */
    public String value;

    public int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", code=" + code +
                '}';
    }
}
