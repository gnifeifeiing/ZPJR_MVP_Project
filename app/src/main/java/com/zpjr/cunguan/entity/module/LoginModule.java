package com.zpjr.cunguan.entity.module;

import com.zpjr.cunguan.common.base.BaseParameter;
import com.zpjr.cunguan.entity.module.ClientModule;
import com.zpjr.cunguan.entity.module.UserModule;

/**
 * Description:      登录返回的实体
 * Autour：          LF
 * Date：            2017/7/27 15:43
 */

public class LoginModule extends BaseParameter {


    private String access_token;

    private UserModule user;

    private ClientModule client;

    private String[] scope;

    private String createdAt;

    private String token_type;


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public UserModule getUser() {
        return user;
    }

    public void setUser(UserModule user) {
        this.user = user;
    }

    public ClientModule getClient() {
        return client;
    }

    public void setClient(ClientModule client) {
        this.client = client;
    }

    public String[] getScope() {
        return scope;
    }

    public void setScope(String[] scope) {
        this.scope = scope;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }


}
