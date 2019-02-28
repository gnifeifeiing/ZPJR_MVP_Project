package com.zpjr.cunguan.adapter;

import android.content.Context;

import com.zpjr.cunguan.ui.activity.security.widget.GestureLock;
import com.zpjr.cunguan.ui.activity.security.widget.GestureLockView;
import com.zpjr.cunguan.ui.activity.security.widget.MyStyleLockView;
import com.zpjr.cunguan.ui.activity.security.widget.NexusStyleLockView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/26 14:41
 */

public class MyGestureLockAdapter implements GestureLock.GestureLockAdapter {

    private Context mContext;
    private List<Integer> mList = new ArrayList<>();

    /**
     * 解锁界面是几阶
     */
    private int mDepth=3;
    /**
     * 最大可重试次数
     */
    private int mUnmatchedCount=5;
    /**
     * block之前的间隔大小
     */
    private int mBlockGapSize=100;

    public MyGestureLockAdapter(Context context, List<Integer> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getDepth() {
        return mDepth;
    }

    /**
     * 正确的解锁手势
     * @return
     */
    @Override
    public int[] getCorrectGestures() {
        int[] d = new int[mList.size()];
        for(int i = 0;i<mList.size();i++){
            d[i] = mList.get(i);
        }
        return d;
    }

    /**
     * 最大可重试次数
     * @return
     */
    @Override
    public int getUnmatchedBoundary() {
        return mUnmatchedCount;
    }

    /**
     * block之前的间隔大小
     * @return
     */
    @Override
    public int getBlockGapSize() {
        return mBlockGapSize;
    }

    @Override
    public GestureLockView getGestureLockViewInstance(Context context, int position) {
        return new NexusStyleLockView(context);
    }
}
