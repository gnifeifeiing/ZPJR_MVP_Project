package com.zpjr.cunguan.view.login;

import android.widget.ImageView;
import android.widget.TextView;

import com.zpjr.cunguan.common.base.IBaseView;
import com.zpjr.cunguan.common.views.ClearEditText;

import java.util.Map;

/**
 * Description:      登录-view接口
 * Autour：          LF
 * Date：            2017/7/27 14:20
 */

public interface IloginView extends IBaseView {

    void initView();

    void initListener();

    ClearEditText getNameClet();

    ClearEditText getPwdClet();

    TextView getTitleTv();

    ImageView getHeaderImageIv();

    //获取登录所需参数
    Map<String,String> getLoginParameter();
}
