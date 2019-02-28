package com.zpjr.cunguan.ui.activity.investment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.adapter.PMDInfoImgAdapter;
import com.zpjr.cunguan.adapter.PreviewImgAdapter;
import com.zpjr.cunguan.common.base.BaseActivity;
import com.zpjr.cunguan.entity.module.LoanImagesModule;

import java.util.List;

/**
 * Description:      公司信息资料图预览
 * Autour：          LF
 * Date：            2017/7/19 17:25
 */

public class PreviewImgActivity extends BaseActivity {

    private RecyclerView mRlv;
    private TextView mTitleTv;

    List<LoanImagesModule.DataBean.IMAGEBean> mImgList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_company_img);
        setActionBarTitle("项目资料");
        initView();
        initData();
    }

    private void initData() {
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            mImgList=JSONArray.parseArray(bundle.get(PMDInfoFragment.class.getName()).toString(),LoanImagesModule.DataBean.IMAGEBean.class);
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRlv.setLayoutManager(linearLayoutManager);
            //设置适配器
            PreviewImgAdapter adapter = new PreviewImgAdapter(this, mImgList);
            mRlv.setAdapter(adapter);
        }
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.preview_rlv);
        mTitleTv = (TextView) findViewById(R.id.preview_titleTv);
    }
}
