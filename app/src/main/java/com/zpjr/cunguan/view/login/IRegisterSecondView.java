package com.zpjr.cunguan.view.login;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.zpjr.cunguan.common.base.IBaseView;
import com.zpjr.cunguan.common.views.ClearEditText;
import com.zpjr.cunguan.common.views.TextImageButton;

/**
 * Description:      注册第二步
 * Autour：          LF
 * Date：            2017/8/2 16:05
 */

public interface IRegisterSecondView extends IBaseView{

    void initView();

    void initListener();

    //初始化图形码
    void getImgCode();

    //获取图形码控件
    TextImageButton getTibCodeTvImgBtn();

    //获取图形码输入控件
    ClearEditText getImageCodeClet();

    //获取验证码输入控件
    ClearEditText getCodeClet();

    //获取密码输入控件
    ClearEditText getPwdClet();

    //获取推荐人输入控件
    ClearEditText getReferralPhoneClet();

    //获取是否同意checkbox
    CheckBox getAgreeCb();

    //获取验证码发送控件
    Button getCodeBtn();

    //验证码发送信息展示控件
    TextView getSendMessageTv();
}
