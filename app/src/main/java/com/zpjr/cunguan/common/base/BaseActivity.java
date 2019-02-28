package com.zpjr.cunguan.common.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.zpjr.cunguan.MyApplication;
import com.zpjr.cunguan.R;


/**
 * Description:      Activity基类
 * Autour：          LF
 * Date：            2017/7/7 16:13
 */
public abstract class BaseActivity<T> extends AppCompatActivity {

    protected ActionBar mActionBar;
    protected TextView mActionBarReturnTv;
    protected TextView mActionBarTitleTv;
    protected ImageView mActionBarHeadIv;
    protected TextView mActionBarContentTv;

    public InputMethodManager mImm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //减少window图层overdraw
        getWindow().setBackgroundDrawable(null);
        // 默认软键盘不弹出
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        mImm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        MyApplication.getInstance().addActivity(this);
        initBaseActionBar();
        initBaseView();
    }

    //自定义actionbar
    protected void initBaseActionBar() {
        mActionBar = getSupportActionBar();
        if (mActionBar == null) {
            return;
        }
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        mActionBar.setCustomView(R.layout.actionbar_base);
        mActionBar.setElevation(0);
    }

    /**
     * 初始化视图控件
     */
    private void initBaseView() {
        mActionBarReturnTv = (TextView) findViewById(R.id.actionbar_returnTv);
        mActionBarTitleTv = (TextView) findViewById(R.id.actionbar_titleTv);
        mActionBarContentTv = (TextView) findViewById(R.id.actionbar_contentTv);
        mActionBarHeadIv = (ImageView) findViewById(R.id.actionbar_headIv);
        mActionBarReturnTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    /**
     * 设置标题
     * @param title
     */
    public void setActionBarTitle(String title) {
        mActionBarTitleTv.setText(title);
    }

    /**
     * 隐藏标题栏
     */
    public void hideActionBar(){
        getSupportActionBar().hide();
    }

    /**
     * 获取版本号
     * @return
     */
    public int getAppVersion() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 获取版本号(内部识别号)
     * @return
     */
    public final String getVersionName() {
        try {
            PackageInfo pi = getPackageManager().getPackageInfo(
                    getPackageName(), 0);
            return pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
