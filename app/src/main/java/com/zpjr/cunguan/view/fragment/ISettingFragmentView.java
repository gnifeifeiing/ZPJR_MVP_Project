package com.zpjr.cunguan.view.fragment;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zpjr.cunguan.common.base.IBaseView;

/**
 * Description:      设置-view接口
 * Autour：          LF
 * Date：            2017/8/21 14:52
 */

public interface ISettingFragmentView extends IBaseView{

    public LinearLayout getmHadLoginLl();

    public TextView getmUserNameTv();

    public LinearLayout getmMessageCenterLl();

    public LinearLayout getmTruthNameLl();

    public TextView getmHadApproveTv();

    public ImageView getmOpenDepositIv();

    public LinearLayout getmMyBankCardLl() ;

    public TextView getmHadBindingTv() ;

    public LinearLayout getmLoginPasswordLl();

    public TextView getmChangePasswordTv();

    public LinearLayout getmBankPhonenumberLl();

    public TextView getmChangeBankPhonenumberTv();

    public LinearLayout getmGesturePasswordLl();

    public TextView getmChangeGestureTv() ;

    public LinearLayout getmSmsSubscribeLl();

    public TextView getmChangeSmsSubscribeTv();

    public LinearLayout getmAboutUsLl() ;

    public LinearLayout getmHelpCenterLl();

    public LinearLayout getmCallServersLl() ;

    public TextView getmServerNumberTv();

    public LinearLayout getmSoftVersionLl();

    public TextView getmApkVersionTv();

    public Button getmLogoutSettingBtn();

}
