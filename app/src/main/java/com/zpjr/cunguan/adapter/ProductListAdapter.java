package com.zpjr.cunguan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.utils.GetTransInformation;
import com.zpjr.cunguan.common.views.WDSeekBar;
import com.zpjr.cunguan.entity.enums.LoanStatus;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.ui.activity.investment.ProductDetailActivity;
import com.zpjr.cunguan.ui.activity.investment.ProductListFragment;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:      产品列表适配器
 * Autour：          LF
 * Date：            2017/7/11 14:59
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    List<LoanModule> mList=new ArrayList<>();
    Context mContext;

    private boolean canBuyProduct;

    private int  wanyuan;
    private int bigDecimal;

    public ProductListAdapter(Context context, List<LoanModule> list) {
        this.mContext = context;
        this.mList = list;
    }

    public void setData( List<LoanModule> list){
        this.mList.addAll(list);
    }

    public void clearData(){
        if(mList.size()>0){
            this.mList.clear();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.investment_product_list_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int position) {
        final LoanModule loan = mList.get(position);

        //条目信息
        viewHolder.messageLl.setTag(loan.getId());
        viewHolder.messageLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, ProductDetailActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable(ProductListFragment.class.getName(),mList.get(position));
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        //产品状态
        if(loan.getStatus().equals(LoanStatus.OPENED.name())){
            viewHolder.stateLl.setVisibility(View.VISIBLE);
            viewHolder.stateTv.setVisibility(View.GONE);
            canBuyProduct =true;
            viewHolder.canInvestMoey=(Double.parseDouble(String.valueOf((loan.getAmount().subtract(loan.getInvestAmount())))))/10000;
            if (100 > Double.parseDouble(String.valueOf((loan.getAmount().subtract(loan.getInvestAmount()))))){
                viewHolder.canInvestMoneyTv.setText("0.00");
            }else if (10000>Double.parseDouble(String.valueOf((loan.getAmount().subtract(loan.getInvestAmount()))))){
                viewHolder.canInvestMoneyTv.setText("0"+String.valueOf(viewHolder.df.format(viewHolder.canInvestMoey)));
            }else{
                viewHolder.canInvestMoneyTv.setText(String.valueOf(viewHolder.df.format(viewHolder.canInvestMoey)));
            }
            viewHolder.canInvestTv.setText("可投金额");
        }else if(loan.getStatus().equals(LoanStatus.SCHEDULED.name())){
            viewHolder.stateLl.setVisibility(View.GONE);
            viewHolder.stateTv.setVisibility(View.VISIBLE);
            canBuyProduct =true;


            String time = getStringTime(loan);
            viewHolder.stateTv.setText(time);
            viewHolder.canInvestTv.setText("开标时间");
        }else if (loan.getStatus().equals(LoanStatus.FINISHED.name())){
            viewHolder.stateLl.setVisibility(View.GONE);
            viewHolder.stateTv.setVisibility(View.VISIBLE);
            canBuyProduct =false;

            viewHolder.stateTv.setText("已满标");
            viewHolder.canInvestTv.setText("项目状态");
        } else if (loan.getStatus().equals(LoanStatus.CLEARED.name())){
            viewHolder.stateLl.setVisibility(View.GONE);
            viewHolder.stateTv.setVisibility(View.VISIBLE);
            canBuyProduct =false;

            viewHolder.stateTv.setText("还款结束");
            viewHolder.canInvestTv.setText("项目状态");
        }else if (loan.getStatus().equals(LoanStatus.SETTLED.name())){
            viewHolder.stateLl.setVisibility(View.GONE);
            viewHolder.stateTv.setVisibility(View.VISIBLE);
            canBuyProduct =false;

            viewHolder.stateTv.setText("还款中");
            viewHolder.canInvestTv.setText("项目状态");
        }else if (loan.getStatus().equals(LoanStatus.CZBANKSETTLED.name())){
            viewHolder.stateLl.setVisibility(View.GONE);
            viewHolder.stateTv.setVisibility(View.VISIBLE);
            canBuyProduct =false;

            viewHolder.stateTv.setText("结算中");
            viewHolder.canInvestTv.setText("项目状态");
        }
        //产品名称
        viewHolder.titleTv.setText(loan.getTitle());
        //第二区域 利率
        if(loan.getLoanRequest().getDeductionRate()==0&&loan.getLoanRequest().getFloatingInterestRate()==0){
            viewHolder.percentFloatingTv.setVisibility(View.GONE);
            viewHolder.addSignTv.setVisibility(View.GONE);
            viewHolder.percentTv.setText(GetTransInformation.deleteZeroOfEnd((loan.getRate() - loan.getLoanRequest().getDeductionRate()) / 100.0) );
        }else if(loan.getLoanRequest().getDeductionRate()!=0){
            viewHolder.percentTv.setText(GetTransInformation.deleteZeroOfEnd(
                    (loan.getRate() - loan.getLoanRequest().getDeductionRate()) / 100.0));
            viewHolder.percentFloatingTv.setVisibility(View.VISIBLE);
            viewHolder.addSignTv.setVisibility(View.VISIBLE);
            viewHolder.percentFloatingTv.setText(GetTransInformation.deleteZeroOfEnd(
                    loan.getLoanRequest().getDeductionRate() / 100.0)+"%");
        }else if(loan.getLoanRequest().getFloatingInterestRate()!=0){
            viewHolder.percentTv.setText(GetTransInformation.deleteZeroOfEnd(
                    (loan.getRate() - loan.getLoanRequest().getDeductionRate()) / 100.0));
            viewHolder.percentFloatingTv.setVisibility(View.VISIBLE);
            viewHolder.addSignTv.setVisibility(View.VISIBLE);
            viewHolder.percentFloatingTv.setText(GetTransInformation.deleteZeroOfEnd(
                    loan.getLoanRequest().getFloatingInterestRate() / 100.0)+"%");
        }

        if (canBuyProduct){
            viewHolder.percentFloatingTv.setBackgroundResource(R.drawable.shape_float_percent_bg);
            viewHolder.addSignTv.setBackgroundResource(R.drawable.shape_float_percent_add_bg);
            viewHolder.percentSignTv.setTextColor(0xffef7d00);
            viewHolder.percentTv.setTextColor(0xffef7d00);
            viewHolder.stateTv.setTextColor(0xffef7d00);

            viewHolder.progressPb.setVisibility(View.VISIBLE);
            viewHolder.pbIv.setVisibility(View.GONE);
        }else{
            viewHolder.percentFloatingTv.setBackgroundResource(R.drawable.shape_float_percent_bg);
            viewHolder.addSignTv.setBackgroundResource(R.drawable.shape_float_percent_add_bg);
            viewHolder.percentSignTv.setTextColor(0xffef7d00);
            viewHolder.percentTv.setTextColor(0xffef7d00);
            viewHolder.stateTv.setTextColor(Color.BLACK);

            viewHolder.progressPb.setVisibility(View.GONE);
            viewHolder.pbIv.setVisibility(View.VISIBLE);
        }
        //第三区域 期限
        if (loan.getDuration().getTotalMonths() <=1 && loan.getDuration().getDays() != 0) {
            if("FLOATING".equals(loan.loanRequest.getDurationType())){
                viewHolder.limitTv.setText(String.format(mContext
                        .getString(R.string.product_floating_day),loan.getLoanRequest().getMinDurationDays(),loan.getDuration()
                        .getDays()));
                viewHolder.limitTimeTv.setText("天");
            }else {
                viewHolder.limitTv.setText(String.format(mContext
                        .getString(R.string.product_limit_day), loan.getDuration()
                        .getTotalDays()));
                viewHolder.limitTimeTv.setText("天");
            }
        } else {
            viewHolder.limitTv.setText(String.format(mContext
                    .getString(R.string.product_limit), loan.getDuration()
                    .getTotalMonths()));
            viewHolder.limitTimeTv.setText("个月");
        }
        /**
         * 第四区域
         */
        viewHolder.progressPb.setProgress((int) loan.getInvestPercent());
        String money=String.valueOf(loan.getAmount());
        int integer = Integer.valueOf(money);
        wanyuan = integer / 10000;
        viewHolder.investAllMoneyTv.setText(String.valueOf(wanyuan)+"万");
        bigDecimal = (int)getBigDecimal(loan);
        viewHolder.progressTv.setText(String.valueOf(bigDecimal)+"%");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        TextView percentTv;
        TextView percentSignTv;
        TextView addSignTv;
        TextView percentFloatingTv;
        TextView limitTv;
        TextView limitTimeTv;
        TextView canInvestMoneyTv;
        TextView stateTv;
        TextView canInvestTv;
        TextView investAllMoneyTv;
        TextView progressTv;

        WDSeekBar progressPb;

        ImageView pbIv;

        LinearLayout messageLl;
        LinearLayout profitLl;
        LinearLayout limitLl;
        LinearLayout stateLl;

        DecimalFormat df = new DecimalFormat("#.00");
        Double canInvestMoey;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleTv=itemView.findViewById(R.id.prodectList_titleTv);
            percentTv=itemView.findViewById(R.id.productList_percentTv);
            percentSignTv=itemView.findViewById(R.id.productList_percentSignTv);
            addSignTv=itemView.findViewById(R.id.productList_addSignTv);
            percentFloatingTv=itemView.findViewById(R.id.productList_percentFloatingTv);
            limitTv=itemView.findViewById(R.id.productList_limitTv);
            limitTimeTv=itemView.findViewById(R.id.productList_limitTimeTv);
            canInvestMoneyTv=itemView.findViewById(R.id.productList_canInvestMoneyTv);
            stateTv=itemView.findViewById(R.id.productList_stateTv);
            canInvestTv=itemView.findViewById(R.id.productList_canInvestTv);
            investAllMoneyTv=itemView.findViewById(R.id.productList_investAllMoneyTv);
            progressTv=itemView.findViewById(R.id.productList_progressTv);

            progressPb=itemView.findViewById(R.id.productList_progressPb);

            pbIv=itemView.findViewById(R.id.productList_pbIv);

            messageLl=itemView.findViewById(R.id.productList_messageLl);
            profitLl=itemView.findViewById(R.id.productList_profitLl);
            limitLl=itemView.findViewById(R.id.productList_limitLl);
            stateLl=itemView.findViewById(R.id.productList_stateLl);
        }
    }

    /**
     * 将开标时间转化为字符串型，小时：分钟 格式
     * @param loan
     * @return
     */
    private String getStringTime(LoanModule loan) {
        Date date=new Date(loan.getTimeOpen());
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
        return sd.format(date);
    }

    /**
     * 将多位小数改为两位小数
     * @param loan
     * @return
     */
    private float getBigDecimal(LoanModule loan) {
        float amount = (float) loan.getInvestPercent();
        BigDecimal big=new BigDecimal(amount);
        return big.setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
    }
}
