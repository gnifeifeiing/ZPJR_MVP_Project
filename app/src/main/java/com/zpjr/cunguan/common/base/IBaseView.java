package com.zpjr.cunguan.common.base;

import android.content.Context;
import android.view.View;

/**
 * Description:      view基类
 * Autour：          LF
 * Date：            2017/7/11 15:28
 */

public interface IBaseView {
    //得到activity的context
    Context getContext();

    //获取activity中view--供snackbar使用
    View getActivityView();
}
