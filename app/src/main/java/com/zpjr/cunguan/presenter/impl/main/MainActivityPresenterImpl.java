package com.zpjr.cunguan.presenter.impl.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.presenter.presenter.main.IMainActivityPresenter;
import com.zpjr.cunguan.ui.activity.main.MainActivity;
import com.zpjr.cunguan.ui.fragment.InvestFragment;
import com.zpjr.cunguan.ui.fragment.MainFragment;
import com.zpjr.cunguan.ui.fragment.MineFragment;
import com.zpjr.cunguan.ui.fragment.SettingFragment;
import com.zpjr.cunguan.view.main.IMainActivityView;

/**
 * Description:      主页presenter
 * Autour：          LF
 * Date：            2017/7/14 11:40
 */

public class MainActivityPresenterImpl implements IMainActivityPresenter{

    private IMainActivityView mView;

    private Fragment mMainFragment;
    private Fragment mInvestFragment;
    private Fragment mMineFragment;
    private Fragment mSettingFragment;

    FragmentTransaction fragmentTransaction;

    public MainActivityPresenterImpl(IMainActivityView view) {
        this.mView = view;
    }

    @Override
    public void hideFragments() {
        if (mMainFragment != null) {
            fragmentTransaction.hide(mMainFragment);
        }
        if (mInvestFragment != null) {
            fragmentTransaction.hide(mInvestFragment);
        }
        if (mMineFragment != null) {
            fragmentTransaction.hide(mMineFragment);
        }
        if (mSettingFragment != null) {
            fragmentTransaction.hide(mSettingFragment);
        }
    }

    @Override
    public void showFragment(View view) {
        fragmentTransaction = ((MainActivity)mView.getContext()).getSupportFragmentManager().beginTransaction();
        //先隐藏所有
        hideFragments();
        switch (view.getId()){
            //首页
            case R.id.mainMenu_mainRBtn:
                if(mMainFragment==null){
                    mMainFragment =new MainFragment();
                    fragmentTransaction.add(R.id.mainMenu_contentFl, mMainFragment);
                }else{
                    fragmentTransaction.show(mMainFragment);
                }

                break;
            //投资
            case R.id.mainMenu_investmentRBtn:
                if(mInvestFragment==null){
                    mInvestFragment =new InvestFragment();
                    fragmentTransaction.add(R.id.mainMenu_contentFl, mInvestFragment);
                }else{
                    fragmentTransaction.show(mInvestFragment);
                }
                break;
            //我的
            case R.id.mainMenu_myRBtn:
                if(mMineFragment==null){
                    mMineFragment =new MineFragment();
                    fragmentTransaction.add(R.id.mainMenu_contentFl, mMineFragment);
                }else{
                    fragmentTransaction.show(mMineFragment);
                }
                break;
            //设置
            case R.id.mainMenu_settingRBtn:
                if(mSettingFragment==null){
                    mSettingFragment =new SettingFragment();
                    fragmentTransaction.add(R.id.mainMenu_contentFl, mSettingFragment);
                }else{
                    fragmentTransaction.show(mSettingFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void setInitFragment() {
        mMainFragment =new MainFragment();
        ((MainActivity)mView.getContext()).getSupportFragmentManager().beginTransaction().add(R.id.mainMenu_contentFl, mMainFragment).commit();
    }
}
