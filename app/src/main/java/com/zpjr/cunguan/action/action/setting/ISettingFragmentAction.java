package com.zpjr.cunguan.action.action.setting;

import com.zpjr.cunguan.common.retrofit.PresenterCallBack;

import java.util.Map;

/**
 * Description:      设置-action接口
 * Autour：          LF
 * Date：            2017/8/21 15:05
 */

public interface ISettingFragmentAction {

    //获取用户信息
    void getUserInfo( String userId, PresenterCallBack callBack);

    //获取是否绑卡信息
    void getMyCard(String userId,   PresenterCallBack callBack);

    //检查更新
    void checkUpdates(  PresenterCallBack callBack);
}
