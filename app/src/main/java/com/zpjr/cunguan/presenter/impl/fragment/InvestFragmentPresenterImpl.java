package com.zpjr.cunguan.presenter.impl.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.action.action.investment.IInvestmentAction;
import com.zpjr.cunguan.action.impl.investment.InvestmentActionImpl;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.utils.CommonUtils;
import com.zpjr.cunguan.common.utils.Constants;
import com.zpjr.cunguan.common.views.WDTabPageIndicator;
import com.zpjr.cunguan.presenter.presenter.fragment.IInvestFragmentPresenter;
import com.zpjr.cunguan.ui.activity.investment.ProductListFragment;
import com.zpjr.cunguan.ui.activity.main.MainActivity;
import com.zpjr.cunguan.ui.fragment.InvestFragment;
import com.zpjr.cunguan.view.fragment.IInvestFragmnetView;
import com.zpjr.cunguan.view.investment.IInvestmentListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:      产品列表FragmentActivity的presenter
 * Autour：          LF
 * Date：            2017/7/17 14:18
 */

public class InvestFragmentPresenterImpl extends BasePresenterImpl implements IInvestFragmentPresenter {

    private BasePagerAdapter mAdapter;

    private Fragment mShortFragment;
    private Fragment mMediumFragment;
    private Fragment mLongFragment;

    private List<Fragment> mProductList = new ArrayList<>();

    private IInvestFragmnetView mView;

    public InvestFragmentPresenterImpl(IInvestFragmnetView view) {
        this.mView = view;
    }

    @Override
    public void initFragment(ViewPager viewPager, WDTabPageIndicator indicator) {
        viewPager.setOffscreenPageLimit(1);

        if (mProductList.size() > 0) {
            mProductList.clear();
        }

        mShortFragment = new ProductListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("product_type", Constants.ASY);
        mShortFragment.setArguments(bundle);
        mProductList.add(mShortFragment);

        mMediumFragment = new ProductListFragment();
        bundle = new Bundle();
        bundle.putString("product_type", Constants.PYY);
        mMediumFragment.setArguments(bundle);
        mProductList.add(mMediumFragment);

        mLongFragment = new ProductListFragment();
        bundle = new Bundle();
        bundle.putString("product_type", Constants.AWY);
        mLongFragment.setArguments(bundle);
        mProductList.add(mLongFragment);

        mAdapter = new BasePagerAdapter(((MainActivity) mView.getContext()).getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        indicator.setViewPager(viewPager);
        setTabPagerIndicator(indicator);
    }

    public void setTabPagerIndicator(WDTabPageIndicator indicator) {
        indicator.setIndicatorMode(WDTabPageIndicator.IndicatorMode.MODE_WEIGHT_NOEXPAND_NOSAME);// 设置模式，一定要先设置模式
        indicator.setDividerColor(Color.parseColor("#00ffffff"));// 设置分割线的颜色
        indicator.setDividerPadding(CommonUtils.dip2px(mView.getContext().getApplicationContext(), 30));
        indicator.setIndicatorColor(Color.parseColor("#ff9d49"));// 设置底部导航线的颜色
        indicator.setTextColorSelected(Color.WHITE);// 设置tab标题选中的颜色
        indicator.setTextColor(Color.parseColor("#e5e5e5"));// 设置tab标题未被选中的颜色
        indicator.setTextSize(CommonUtils.sp2px(mView.getContext().getApplicationContext(), 14));// 设置字体大小
        indicator.setTextSizeSelected(CommonUtils.sp2px(mView.getContext().getApplicationContext(), 16));//设置tab标题被选中的大小
        indicator.setIndicatorHeight(CommonUtils.dip2px(mView.getContext().getApplicationContext(), 4));
    }

    /**
     * viewpager适配器
     */
    class BasePagerAdapter extends FragmentPagerAdapter {
        String[] titles;

        public BasePagerAdapter(FragmentManager fm) {
            super(fm);
            this.titles = CommonUtils.getStringArray(R.array.product_list_titles);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mProductList.get(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
