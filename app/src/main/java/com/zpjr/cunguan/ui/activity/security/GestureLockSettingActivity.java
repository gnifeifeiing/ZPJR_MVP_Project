package com.zpjr.cunguan.ui.activity.security;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.adapter.MyGestureLockAdapter;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.presenter.impl.security.GestureLockSettingPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.security.IGestureLockSettingPresenter;
import com.zpjr.cunguan.ui.activity.security.widget.GestureHintView;
import com.zpjr.cunguan.ui.activity.security.widget.GestureLock;
import com.zpjr.cunguan.view.security.IGestureLockSettingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:      手势密码设置
 * Autour：          LF
 * Date：            2017/7/26 10:52
 */
public class GestureLockSettingActivity extends BaseActivity implements IGestureLockSettingView, View.OnClickListener {

    private GestureLock mSettingLockGov;
    private GestureHintView mPreViewGhv;
    private TextView mResetDrawTv;

    private IGestureLockSettingPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_lock_setting);

        // 隐藏标题栏
        hideActionBar();
        mPresenter=new GestureLockSettingPresenterImpl(this);
        initView();
        initListener();
        setAdapter();
    }

    private void initListener() {
        mResetDrawTv.setOnClickListener(this);
    }

    private void initView() {
        mSettingLockGov = (GestureLock) findViewById(R.id.gestureLock_settingLockGov);
        mPreViewGhv = (GestureHintView) findViewById(R.id.gestureLock_preViewGhv);
        mResetDrawTv= (TextView) findViewById(R.id.gestureLock_resetDrawTv);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getActivityView() {
        return mSettingLockGov;
    }

    @Override
    public void setAdapter() {
        mPresenter.setAdapter();
    }

    @Override
    public GestureLock getGestureLock() {
        return mSettingLockGov;
    }

    @Override
    public GestureHintView getGestureHintView() {
        return mPreViewGhv;
    }

    @Override
    public TextView getResetDrawView() {
        return mResetDrawTv;
    }

    @Override
    public void onClick(View view) {
        mPresenter.resetGestureLock();
    }
}
