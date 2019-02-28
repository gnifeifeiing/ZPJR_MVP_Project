package com.zpjr.cunguan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Description:      更多详情的viewpager适配器
 * Autour：          LF
 * Date：            2017/7/18 17:36
 */

public class PMDViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public PMDViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        // TODO Auto-generated constructor stub
        mFragments=fragments;
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return mFragments.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mFragments.size();
    }
}