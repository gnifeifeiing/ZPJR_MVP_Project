package com.zpjr.cunguan.ui.activity.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zpjr.cunguan.R;
import com.zpjr.cunguan.common.base.BaseActivity;

/**
 * Description:      提示绑卡
 * Autour：          LF   
 * Date：            2017/8/29 10:05
 */ 
public class OpenWarmPromptActivity extends BaseActivity implements View.OnClickListener {

    private Button mBindZSBtn;
    private Button mBindOtherBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarTitle("温馨提示");
        setContentView(R.layout.activity_open_warm_prompt);
        initView();
        initListener();
    }

    private void initListener() {
        mBindZSBtn.setOnClickListener(this);
        mBindOtherBtn.setOnClickListener(this);
    }

    private void initView() {
        mBindZSBtn= (Button) findViewById(R.id.openWarm_bindZSBtn);
        mBindOtherBtn= (Button) findViewById(R.id.openWarm_bindOtherBtn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.openWarm_bindZSBtn:
                break;
            case R.id.openWarm_bindOtherBtn:
                break;
        }
    }
}
