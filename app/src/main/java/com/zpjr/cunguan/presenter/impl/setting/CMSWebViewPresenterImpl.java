package com.zpjr.cunguan.presenter.impl.setting;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zpjr.cunguan.action.action.setting.ICMSWebViewAction;
import com.zpjr.cunguan.action.impl.setting.CMSWebViewActionImpl;
import com.zpjr.cunguan.common.base.BasePresenterImpl;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.entity.module.CMSResponseModule;
import com.zpjr.cunguan.presenter.presenter.setting.ICMSWebViewPresenter;
import com.zpjr.cunguan.view.setting.ICMSWebView;

import java.util.List;

/**
 * Description:      帮助中心详情
 * Autour：          LF
 * Date：            2017/8/22 11:32
 */

public class CMSWebViewPresenterImpl extends BasePresenterImpl implements ICMSWebViewPresenter {

    private ICMSWebViewAction mAction;
    private ICMSWebView mView;

    public CMSWebViewPresenterImpl(ICMSWebView view){
        this.mAction=new CMSWebViewActionImpl();
        this.mView=view;
    }

    @Override
    public void getCmsContent(String url) {
        showLoadingDialog(mView.getContext());
        mAction.getCmsContent(url, new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                dismissLoadingDialog();
                if (result!=null) {
                    try {
                        List<CMSResponseModule> moduleList = JSON.parseArray(result.toString(), CMSResponseModule.class);
                        if (moduleList.size()>0) {
                            String content = moduleList.get(0).getContent();
                            mView.webViewInitial(content);
                        } else {
                            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "获取协议失败，请重试", SnackbarUtil.INFO).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        SnackbarUtil.ShortSnackbar(mView.getActivityView(), "获取协议失败，请重试", SnackbarUtil.INFO).show();
                    }

                } else {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "获取协议失败，请重试", SnackbarUtil.INFO).show();
                }

            }

            @Override
            public void onFail(String errMsg) {
                dismissLoadingDialog();
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
            }
        });
    }

    @Override
    public void getAboutUsContent(String url) {
        showLoadingDialog(mView.getContext());
        mAction.getAboutUsContent(url, new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                dismissLoadingDialog();
                if (result!=null) {
                    try {
                        List<CMSResponseModule> moduleList = JSON.parseArray(result.toString(), CMSResponseModule.class);
                        if (moduleList.size()>0) {
                            String content = moduleList.get(0).getContent();
                            mView.webViewInitial(content);
                        } else {
                            SnackbarUtil.ShortSnackbar(mView.getActivityView(), "获取协议失败，请重试", SnackbarUtil.INFO).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        SnackbarUtil.ShortSnackbar(mView.getActivityView(), "获取协议失败，请重试", SnackbarUtil.INFO).show();
                    }

                } else {
                    SnackbarUtil.ShortSnackbar(mView.getActivityView(), "获取协议失败，请重试", SnackbarUtil.INFO).show();
                }
            }

            @Override
            public void onFail(String errMsg) {
                dismissLoadingDialog();
                SnackbarUtil.ShortSnackbar(mView.getActivityView(), errMsg, SnackbarUtil.INFO).show();
            }
        });
    }
}
