package com.zpjr.cunguan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.entity.module.LoanModule;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/12 10:23
 */

public class MyBaseAdpater extends BaseAdapter {

    List<LoanModule> mList;
    Context mContext;

    public MyBaseAdpater(Context context, List<LoanModule> list) {
        Log.e(MyBaseAdpater.class.getName(),"---....");
        this.mContext = context;
        this.mList = list;
    }

    public void setData(List<LoanModule> list){
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        MyViewHolder holder=null;
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.test_list_item, null);
            holder=new MyViewHolder();
            holder.titleTv=convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        }
        else {
            holder= (MyViewHolder) convertView.getTag();
        }
        holder.titleTv.setText(mList.get(i).title);
        return convertView;
    }

    class MyViewHolder{

        TextView titleTv;
    }
}
