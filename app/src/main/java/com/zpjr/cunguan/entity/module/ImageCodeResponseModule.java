package com.zpjr.cunguan.entity.module;

/**
 * Description:      图形码
 * Autour：          LF
 * Date：            2017/8/2 16:27
 */

public class ImageCodeResponseModule extends ApiResponseModule {
    private String created_at;

    private int ttl;

    private String token;

    private String captcha;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
