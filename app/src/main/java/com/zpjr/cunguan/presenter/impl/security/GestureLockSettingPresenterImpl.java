package com.zpjr.cunguan.presenter.impl.security;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zpjr.cunguan.action.impl.investment.InvestmentActionImpl;
import com.zpjr.cunguan.adapter.MyGestureLockAdapter;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.presenter.presenter.security.IGestureLockSettingPresenter;
import com.zpjr.cunguan.ui.activity.security.widget.GestureLock;
import com.zpjr.cunguan.view.investment.IInvestmentListView;
import com.zpjr.cunguan.view.security.IGestureLockSettingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:      手势密码设置
 * Autour：          LF
 * Date：            2017/7/26 15:20
 */

public class GestureLockSettingPresenterImpl implements IGestureLockSettingPresenter, GestureLock.OnGestureEventListener {

    private IGestureLockSettingView mView;
    private MyGestureLockAdapter mAdapter;

    private List<Integer> mList = new ArrayList<>();
    int totalCount = 1;

    public GestureLockSettingPresenterImpl(IGestureLockSettingView view) {
        this.mView = view;
    }

    @Override
    public void setAdapter() {
        mAdapter = new MyGestureLockAdapter(mView.getContext(), mList);
        mView.getGestureLock().setAdapter(mAdapter);
        mView.getGestureLock().setOnGestureEventListener(this);
    }

    @Override
    public void resetGestureLock() {
        totalCount = 1;
        mList.clear();
        mView.getResetDrawView().setVisibility(View.INVISIBLE);
        mView.getGestureHintView().setCode("");
        mView.getGestureLock().clear();
    }


    @Override
    public void onGestureEvent(boolean matched) {
        //设置预览手势
        mView.getGestureHintView().setCode("");
        mView.getGestureHintView().setCode(mList.toString());
        if (mList.size() >= 4) {
            //记忆首次手势并作为密码
            if (totalCount == 1) {
                //首次输入，设置其正确解锁集合mList
                mAdapter = new MyGestureLockAdapter(mView.getContext(), mList);
                mView.getGestureLock().setAdapter(mAdapter);
            }

            //判断非第一次手势是否匹配第一次手势
            if (totalCount > 1) {
                if (matched) {
                    totalCount = 1;
                    mList.clear();
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "手势正确!", SnackbarUtil.INFO).show();
                    return;
                } else {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "两次手势不一致!", SnackbarUtil.INFO).show();
                }
                mView.getResetDrawView().setVisibility(View.VISIBLE);
            }
            totalCount++;
        }else{
            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "至少连接4个点，请重试!", SnackbarUtil.INFO).show();
        }

        mList.clear();
        mView.getGestureLock().clear();
    }

    @Override
    public void onUnmatchedExceedBoundary() {
        SnackbarUtil.ShortSnackbar(mView.getActivityView(), "输入5次错误!", SnackbarUtil.INFO).show();
    }

    @Override
    public void onBlockSelected(int position) {
        mList.add(position);
    }
}
