package com.zpjr.cunguan.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.interfaces.IBitmapPostExecute;
import com.zpjr.cunguan.common.utils.AsyncImageLoader;
import com.zpjr.cunguan.common.cache.BitmapUtils;
import com.zpjr.cunguan.entity.module.LoanImagesModule;

import java.util.List;

/**
 * Description:      图片浏览适配器
 * Autour：          LF
 * Date：            2017/7/19 14:57
 */

public class PreviewImgAdapter  extends RecyclerView.Adapter<PreviewImgAdapter.MyViewHolder> {

    private AsyncImageLoader asyncImageLoader;

    List<LoanImagesModule.DataBean.IMAGEBean> mList;
    Context mContext;
    BitmapUtils bitmapUtils;

    public PreviewImgAdapter(Context context, List<LoanImagesModule.DataBean.IMAGEBean> list) {
        this.mContext = context;
        this.mList = list;
        bitmapUtils = new BitmapUtils();
        asyncImageLoader = new AsyncImageLoader();
    }


    @Override
    public PreviewImgAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PreviewImgAdapter.MyViewHolder holder = new PreviewImgAdapter.MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.preview_img_list_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final PreviewImgAdapter.MyViewHolder holder, int position) {
        LoanImagesModule.DataBean.IMAGEBean imagesModule = mList.get(position);
        //三级缓存显示图片
        bitmapUtils.getBitmap(imagesModule.getUri(), new IBitmapPostExecute() {
            @Override
            public void onPostExecuteSuccess(Bitmap bitmap) {
                //竖直显示的bitmap
                if(bitmap.getHeight()>bitmap.getWidth()){
                    holder.titleTv.setBackgroundColor(Color.argb(150,194,194,194));
                }
                //横向显示时
                else{
                    holder.titleTv.setBackgroundColor(Color.BLACK);
                }
                holder.titleTv.setVisibility(View.VISIBLE);
                holder.img.setImageBitmap(bitmap);
            }
        });
        holder.titleTv.setText(imagesModule.getContent().substring(0,imagesModule.getContent().lastIndexOf('.')));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView titleTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.previewImg_img);
            titleTv = itemView.findViewById(R.id.preview_titleTv);
        }
    }
}
