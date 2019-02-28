package com.zpjr.cunguan.view.security;

import android.widget.TextView;

import com.zpjr.cunguan.common.base.IBaseView;
import com.zpjr.cunguan.ui.activity.security.widget.GestureHintView;
import com.zpjr.cunguan.ui.activity.security.widget.GestureLock;

/**
 * Description:      手势密码设置-view接口
 * Autour：          LF
 * Date：            2017/7/26 15:14
 */

public interface IGestureLockSettingView extends IBaseView{

    //设置GestureLockView适配器
    void setAdapter();

    //获取GestureLock-view
    GestureLock getGestureLock();

    //获取GestureHintView-view
    GestureHintView getGestureHintView();

    //获取重新绘制-view
    TextView getResetDrawView();
}
