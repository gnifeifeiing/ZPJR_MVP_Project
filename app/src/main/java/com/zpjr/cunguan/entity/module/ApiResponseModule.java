package com.zpjr.cunguan.entity.module;

import android.text.TextUtils;

import com.zpjr.cunguan.common.utils.ErrorInfo;

import java.util.List;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/8/1 14:54
 */

public class ApiResponseModule {
    private boolean success;
    /**
     * 错误列表
     */
    private List<ApiErrorModule> error;

    private boolean needToLogin = false;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public List<ApiErrorModule> getError() {
        return error;
    }

    public void setError(List<ApiErrorModule> error) {
        this.error = error;
    }

    public boolean isNeedToLogin() {
        return needToLogin;
    }

    public void setNeedToLogin(boolean needToLogin) {
        this.needToLogin = needToLogin;
    }

    public boolean isError() {
        if (error != null && error.size() > 0) {
            return !TextUtils.isEmpty(error.get(0).getMessage());
        } else {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return ErrorInfo.getMsg(error.get(0).getMessage());
        } catch (Exception e) {
            return "未知错误";
        }
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", error=" + error +
                ", needToLogin=" + needToLogin +
                '}';
    }
}
