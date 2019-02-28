package com.zpjr.cunguan.entity.module;

/**
 * Description:      注册接口返回module
 * Autour：          LF
 * Date：            2017/8/3 14:55
 */

public class RegisterResponseModule  extends ApiResponseModule {

    /*{
        "data":{
        "user":{
            "id":"4B76AD16-2297-4DA5-AF22-2DE631274E39",
            "clientCode":"ZMIT",
            "name":null,
            "loginName":"fhjr15848245558",
            "idNumber":null,
            "mobile":"15848245558",
            "email":"notavailable@creditcloud.com",
            "source":"WEB",
            "employeeId":null,
            "lastModifiedBy":null,
            "channel":null,
            "lastLoginDate":null,
            "registerDate":1427971562000,
            "enabled":true,
            "referralEntity":null,
            "enterprise":false,
            "registryRewarded":false,
            "referralRewarded":false,
            "groupId":null
        }
    },
        "error":[

    ],
        "success":true
    }*/

    private RegistModule data ;

    public RegistModule getData() {
        return data;
    }

}
