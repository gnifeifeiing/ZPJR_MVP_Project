package com.zpjr.cunguan.common.cache;

import android.content.Context;
import android.content.SharedPreferences;

import com.zpjr.cunguan.MyApplication;

/**
 * Description:      SharedPreference存储
 * Autour：          LF
 * Date：            2017/7/7 16:28
 */
public class SharedPreferenceCache {

    private static SharedPreferenceCache mInstance;
    private static SharedPreferences settings;

    /**
     * 单例
     *
     * @return SharedPreferencesUser对象
     */
    public static SharedPreferenceCache getInstance() {
        if (mInstance == null) {
            synchronized (SharedPreferenceCache.class) {
                if (mInstance == null) {
                    mInstance = new SharedPreferenceCache();
                    settings = MyApplication.getInstance().getSharedPreferences(SharedPreferenceCache.class.getName(),
                            Context.MODE_PRIVATE);
                }
            }
        }
        return mInstance;
    }

    public void putPres(String key, String value) {
        SharedPreferences.Editor editor = settings.edit();
        // 客户ID
        if (key.equals("UserId")) {
            editor.putString("UserId", value);
        }
        // 是否登录 0-否 1-是
        else if (key.equals("IsLogin")) {
            editor.putString("IsLogin", value);
        }
        //手势
        else if (key.equals("Gesture")) {
            editor.putString("Gesture", value);
        }
        // 登录手机号
        else if (key.equals("LoginMobile")) {
            editor.putString("LoginMobile", value);
        }
        // 登录密码
        else if (key.equals("CustPassword")) {
            editor.putString("CustPassword", value);
        }
        // 用户姓名
        else if (key.equals("UserName")) {
            editor.putString("UserName", value);
        }
        // token
        else if (key.equals("AccessToken")) {
            editor.putString("AccessToken", value);
        }
        // groupId
        else if (key.equals("GroupId")) {
            editor.putString("GroupId", value);
        }
        // 是否开户0-否 1-是
        else if (key.equals("KaiHu")) {
            editor.putString("KaiHu", value);
        }
        // 身份证号
        else if (key.equals("CardNum")) {
            editor.putString("CardNum", value);
        }
        // 企业
        else if (key.equals("Enterprise")) {
            editor.putString("Enterprise", value);
        }
        // 银行手机号
        else if (key.equals("BankMobile")) {
            editor.putString("BankMobile", value);
        }
        // 银行类型
        else if (key.equals("BankType")) {
            editor.putString("BankType", value);
        }
        else {
            editor.putString(key, value);
        }
        editor.commit();
    }


    public String getPres(String key) {
        String value = "";
        if (key.equals("UserId")) {
            value = settings.getString("UserId", "");
        } else if (key.equals("IsLogin")) {
            value = settings.getString("IsLogin", "0");
        } else if (key.equals("Gesture")) {
            value = settings.getString("Gesture", "");
        } else if (key.equals("LoginMobile")) {
            value = settings.getString("LoginMobile", "");
        } else if (key.equals("CustPassword")) {
            value = settings.getString("CustPassword", "");
        } else if (key.equals("UserName")) {
            value = settings.getString("UserName", "");
        } else if (key.equals("AccessToken")) {
            value = settings.getString("AccessToken", "");
        } else if (key.equals("GroupId")) {
            value = settings.getString("GroupId", "");
        } else if (key.equals("KaiHu")) {
            value = settings.getString("KaiHu", "");
        }else if (key.equals("CardNum")) {
            value = settings.getString("CardNum", "");
        }else if (key.equals("Enterprise")) {
            value = settings.getString("Enterprise", "");
        }else if (key.equals("BankMobile")) {
            value = settings.getString("BankMobile", "");
        }else if (key.equals("BankType")) {
            value = settings.getString("BankType", "");
        }else {
            value = settings.getString(key, "");
        }
        return value;
    }


    /**
     * 是否存在该字段
     *
     * @param result
     * @return
     */
    public boolean existResult(String result) {
        return settings.contains(result);
    }

    /**
     * 移除该字段
     *
     * @param preName
     */
    public void removePre(String preName) {
        settings.edit().remove(preName).commit();
    }

    /**
     * 清空用户信息
     */
    public void clearUserInfo() {
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();
    }

}
