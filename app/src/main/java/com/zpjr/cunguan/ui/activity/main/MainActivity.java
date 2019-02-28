package com.zpjr.cunguan.ui.activity.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.presenter.impl.main.MainActivityPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.main.IMainActivityPresenter;
import com.zpjr.cunguan.ui.fragment.InvestFragment;
import com.zpjr.cunguan.ui.fragment.MainFragment;
import com.zpjr.cunguan.ui.fragment.MineFragment;
import com.zpjr.cunguan.ui.fragment.SettingFragment;
import com.zpjr.cunguan.view.main.IMainActivityView;

/**
 * Description:      主页
 * Autour：          LF   
 * Date：            2017/7/7 11:11
 */ 
public class MainActivity extends BaseActivity implements View.OnClickListener,IMainActivityView {

    private RadioButton mMainRBtn;
    private RadioButton mInvestmentRBtn;
    private RadioButton mMyRBtn;
    private RadioButton mSettingRBtn;

    private IMainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏掉整个ActionBar
        setContentView(R.layout.activity_main);
        presenter=new MainActivityPresenterImpl(this);
        initView();
        initEvent();
        initMainFragment();
    }

    @Override
    public void initView() {
        mMainRBtn= (RadioButton) findViewById(R.id.mainMenu_mainRBtn);
        mInvestmentRBtn= (RadioButton) findViewById(R.id.mainMenu_investmentRBtn);
        mMyRBtn= (RadioButton) findViewById(R.id.mainMenu_myRBtn);
        mSettingRBtn= (RadioButton) findViewById(R.id.mainMenu_settingRBtn);
    }

    @Override
    public void initEvent() {
        mMainRBtn.setOnClickListener(this);
        mInvestmentRBtn.setOnClickListener(this);
        mMyRBtn.setOnClickListener(this);
        mSettingRBtn.setOnClickListener(this);
    }

    @Override
    public void initMainFragment() {
        presenter.setInitFragment();
    }

    @Override
    public void onClick(View view) {
       presenter.showFragment(view);
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getActivityView() {
        return mMainRBtn;
    }
}
