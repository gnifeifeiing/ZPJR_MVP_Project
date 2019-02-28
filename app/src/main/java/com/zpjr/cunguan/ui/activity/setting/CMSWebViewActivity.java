package com.zpjr.cunguan.ui.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.presenter.impl.setting.CMSWebViewPresenterImpl;
import com.zpjr.cunguan.presenter.presenter.setting.ICMSWebViewPresenter;
import com.zpjr.cunguan.view.setting.ICMSWebView;

public class CMSWebViewActivity extends BaseActivity implements ICMSWebView {

    private TextView mIntroduceTitle;

    private WebView mWebview;

    private ProgressBar mBar;

    private String mStrUrl;

    private ICMSWebViewPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmsweb_view);
        mPresenter=new CMSWebViewPresenterImpl(this);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = this.getIntent();
        if (intent != null) {
            setActionBarTitle(intent.getStringExtra("title"));
            this.mIntroduceTitle.setText(intent.getStringExtra("title"));
            mStrUrl = intent.getStringExtra("url");
        }
        //关于我们
        if(mStrUrl.equals("关于我们")){
            mPresenter.getAboutUsContent(mStrUrl);
        }
        //帮助中心
        else{
            mPresenter.getCmsContent(mStrUrl);
        }
    }

    private void initView() {
        mIntroduceTitle = (TextView) findViewById(R.id.introducetitleTv);
        mWebview = (WebView) findViewById(R.id.web_agree);
        mBar = (ProgressBar) findViewById(R.id.myProgressBar);
    }

    public void webViewInitial(String content) {
        mWebview.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
        mWebview.getSettings().setLoadWithOverviewMode(true);
        mWebview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //webview.getSettings().setTextSize(WebSettings.TextSize.SMALLER);// 设置支持缩放
        mWebview.getSettings().setSupportZoom(true);// 设置支持缩放
        mWebview.getSettings().setBuiltInZoomControls(true);
        mWebview.getSettings().setDisplayZoomControls(false);// 设置缩放工具不显示
        mWebview.setWebChromeClient(new MyWebChromeClient());
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public View getActivityView() {
        return mWebview;
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mBar.setVisibility(View.GONE);
            } else {
                if (View.GONE == mBar.getVisibility()) {
                    mBar.setVisibility(View.VISIBLE);
                }
                mBar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }

    }
}
