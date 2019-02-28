package com.zpjr.cunguan.action.action.investment;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

/**
 * Description:      更多详情--项目信息接口
 * Autour：          LF
 * Date：            2017/7/19 14:23
 */

public interface IPMDInfoAction {

    //获取公司营业执照等信息
    void getCompanyImg(String loanId, final PresenterCallBack callBack);
}
