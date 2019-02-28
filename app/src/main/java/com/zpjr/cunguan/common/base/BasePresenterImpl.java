package com.zpjr.cunguan.common.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.alibaba.fastjson.JSONObject;
import com.zpjr.cunguan.MyApplication;
import com.zpjr.cunguan.R;
import com.zpjr.cunguan.action.action.setting.ISettingFragmentAction;
import com.zpjr.cunguan.action.impl.setting.SettingFragmentAction;
import com.zpjr.cunguan.common.cache.SharedPreferenceCache;
import com.zpjr.cunguan.common.retrofit.PresenterCallBack;
import com.zpjr.cunguan.common.utils.SnackbarUtil;
import com.zpjr.cunguan.common.views.LoadingDialog;
import com.zpjr.cunguan.common.views.PrompfDialog;
import com.zpjr.cunguan.entity.module.VersionModule;
import com.zpjr.cunguan.ui.activity.login.LoginActivity;

/**
 * Description:      业务逻辑-presenter基类
 * Autour：          LF
 * Date：            2017/7/27 15:26
 */

public class BasePresenterImpl {

    public LoadingDialog shapeLoadingDialog;

    private ISettingFragmentAction mAction;

    public BasePresenterImpl() {

    }

    /**
     * apk检查更新
     * @param context
     */
    public void checkUpdate(final Context context, final View view) {
        if (mAction == null) {
            mAction = new SettingFragmentAction();
        }
        mAction.checkUpdates(new PresenterCallBack() {
            @Override
            public void onSuccess(Object result) {
                if (result != null) {
                    VersionModule module = JSONObject.parseObject(result.toString(), VersionModule.class);
                    if (module.getVersionCode() <= getAppVersion(context)) {
                        showUpdateDialog(context, module.getUrl(), module.getName(), module.getVersionName());
                    }else{
                        SnackbarUtil.ShortSnackbar(view, "已是最新版本", SnackbarUtil.INFO).show();
                    }
                } else {
                    SnackbarUtil.ShortSnackbar(view, "检查更新失败，请重试", SnackbarUtil.INFO).show();
                }
            }

            @Override
            public void onFail(String errMsg) {
                try {
                    SnackbarUtil.ShortSnackbar(view, errMsg, SnackbarUtil.INFO).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 获取版本号
     *
     * @return
     */
    public int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**********************************加载框*******************************/
    /**
     * 加载框
     *
     * @param context
     */
    public void showLoadingDialog(Context context) {
        if (shapeLoadingDialog == null) {
            shapeLoadingDialog = new LoadingDialog.Builder(context)
                    .loadText(context.getResources().getString(R.string.loading_text))
                    .build();
            shapeLoadingDialog.show();
        } else {
            shapeLoadingDialog.show();
        }
    }

    /**
     * 加载内容框
     *
     * @param context
     */
    public void showLoadingDialog(Context context, String content) {
        if (shapeLoadingDialog == null) {
            shapeLoadingDialog = new LoadingDialog.Builder(context)
                    .loadText(content)
                    .build();
            shapeLoadingDialog.show();
        } else {
            shapeLoadingDialog.show();
        }
    }

    public void dismissLoadingDialog() {
        if (shapeLoadingDialog != null) {
            shapeLoadingDialog.dismiss();
        }
    }

    /*******************************电话拨打弹框*******************************/
    Dialog call_dialog;
    Button btn_call;

    public void showCallDialog(final Context context, final String phone_num) {
        if (call_dialog == null) {
            View view = ((BaseActivity) context).getLayoutInflater().inflate(R.layout.call_dialog, null);
            call_dialog = new Dialog(context, R.style.transparentFrameWindowStyle);
            call_dialog.setContentView(view, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            Window window = call_dialog.getWindow();
            // 设置显示动画
            window.setWindowAnimations(R.style.main_menu_animstyle);
            WindowManager.LayoutParams wl = window.getAttributes();
            wl.x = 0;
            wl.y = ((BaseActivity) context).getWindowManager().getDefaultDisplay().getHeight();
            // 以下这两句是为了保证按钮可以水平满屏
            wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
            wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;

            // 设置显示位置
            call_dialog.onWindowAttributesChanged(wl);
            // 设置点击外围解散
            call_dialog.setCanceledOnTouchOutside(true);
            call_dialog.show();
            btn_call = (Button) view.findViewById(R.id.btn_call);
            btn_call.setText(phone_num);
            Button btn_cancle = (Button) view.findViewById(R.id.btn_cancle);
            btn_call.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (phone_num != null && !phone_num.equals("")) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri
                                .parse("tel:" + phone_num));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        call_dialog.dismiss();
                    }
                }
            });
            btn_cancle.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    call_dialog.dismiss();
                }
            });
        } else {
            btn_call.setText(phone_num);
            call_dialog.show();
        }
    }


    /*******************************版本更新弹框*******************************/
    PrompfDialog updateDialog;

    public void showUpdateDialog(final Context context,
                                 final String versionPath,
                                 final String versionName,
                                 final String versionCode) {
        if (updateDialog == null) {
            updateDialog = new PrompfDialog(context,
                    R.style.transparentFrameWindowStyle, "更  新", "关  闭",
                    "检测到最新版本，需要更新吗？", "中平金融");
            updateDialog.setCanceledOnTouchOutside(false);
            updateDialog.setUpdateOnClickListener(new PrompfDialog.UpdateOnclickListener() {
                @Override
                public void dismiss() {
                }

                @Override
                public void BtnYesOnClickListener(View v) {
//                    Intent it = new Intent(context,NotificationUpdateActivity.class);
//                    it.putExtra("versionPath", versionPath);
//                    it.putExtra("versionName", versionName);
//                    it.putExtra("versionCode", versionCode);
//                    context.startActivity(it);
//                    phone.setDownload(true);
                    updateDialog.dismiss();
                }

                @Override
                public void BtnCancleOnClickListener(View v) {
                    updateDialog.dismiss();
                }
            });
            Window window = updateDialog.getWindow();
            window.setGravity(Gravity.CENTER);
            updateDialog.show();
        } else {
            updateDialog.show();
        }
    }


    /*******************************退出登录弹框*******************************/
    PrompfDialog logOutDialog;

    public void showLogOutDialog(final Context context) {
        if (logOutDialog == null) {
            logOutDialog = new PrompfDialog(context,
                    R.style.transparentFrameWindowStyle, "退  出", "关  闭",
                    "您确定要退出登录账户吗？", "中平金融");
            logOutDialog.setCanceledOnTouchOutside(false);
            logOutDialog
                    .setUpdateOnClickListener(new PrompfDialog.UpdateOnclickListener() {
                        @Override
                        public void dismiss() {
                        }

                        @Override
                        public void BtnYesOnClickListener(View v) {
                            SharedPreferenceCache.getInstance().clearUserInfo();
                            MyApplication.IS_LOGIN = false;
                            Intent intent = new Intent(context, LoginActivity.class);
                            context.startActivity(intent);
                            logOutDialog.dismiss();
                        }

                        @Override
                        public void BtnCancleOnClickListener(View v) {
                            logOutDialog.dismiss();
                        }
                    });
            Window window = logOutDialog.getWindow();
            window.setGravity(Gravity.CENTER);
            logOutDialog.show();
        } else {
            logOutDialog.show();
        }
    }
}
