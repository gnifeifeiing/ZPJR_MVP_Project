package com.zpjr.cunguan.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

/**
 * 作者：WD on 2016/9/13 10:14
 * 邮箱：pmccwd@mrteam.cn
 */
public class WDSeekBar extends SeekBar {
    public WDSeekBar(Context context) {
        super(context);
    }

    public WDSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WDSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return false;
    }

    public void setProgressDrawable(int loan_pb_bg) {

    }
}
