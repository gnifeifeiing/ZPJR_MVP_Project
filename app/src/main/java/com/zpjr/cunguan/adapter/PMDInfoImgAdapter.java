package com.zpjr.cunguan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONArray;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.utils.AsyncImageLoader;
import com.zpjr.cunguan.common.cache.BitmapUtils;
import com.zpjr.cunguan.entity.module.LoanImagesModule;
import com.zpjr.cunguan.ui.activity.investment.PMDInfoFragment;
import com.zpjr.cunguan.ui.activity.investment.PreviewImgActivity;

import java.util.List;

/**
 * Description:      更多详情--公司资料图片适配器
 * Autour：          LF
 * Date：            2017/7/19 14:57
 */

public class PMDInfoImgAdapter extends RecyclerView.Adapter<PMDInfoImgAdapter.MyViewHolder> {

    private AsyncImageLoader asyncImageLoader;

    List<LoanImagesModule.DataBean.IMAGEBean> mList;
    Context mContext;
    RecyclerView mRlv;
    BitmapUtils bitmapUtils;

    public PMDInfoImgAdapter(Context context, List<LoanImagesModule.DataBean.IMAGEBean> list, RecyclerView rlv) {
        this.mContext = context;
        this.mList = list;
        this.mRlv = rlv;
        bitmapUtils = new BitmapUtils();
        asyncImageLoader = new AsyncImageLoader();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PMDInfoImgAdapter.MyViewHolder holder = new PMDInfoImgAdapter.MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.pmd_info_company_img_layout, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LoanImagesModule.DataBean.IMAGEBean imagesModule = mList.get(position);
        //三级缓存显示图片
        bitmapUtils.disPlay(holder.img, imagesModule.getUri());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.PMDInfo_img);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(mContext, PreviewImgActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString(PMDInfoFragment.class.getName(), JSONArray.toJSONString(mList));
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
