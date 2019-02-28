package com.zpjr.cunguan.view.setting;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zpjr.cunguan.common.base.IBaseView;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/8/29 10:58
 */

public interface IUpdateBankMobileView extends IBaseView {

    public TextView getmSendMessageTv();

    public EditText getmOldPhoneEt();

    public EditText getmNewPhoneEt() ;

    public LinearLayout getmDynamicNumberLl();

    public EditText getmDynamicNumberEt() ;

    public TextView getmDynamicNumberTv();

    public Button getmCommitBtn();
}
