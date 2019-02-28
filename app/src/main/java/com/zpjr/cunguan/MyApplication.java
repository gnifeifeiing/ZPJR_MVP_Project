package com.zpjr.cunguan;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.zpjr.cunguan.common.cache.SharedPreferenceCache;
import com.zpjr.cunguan.common.utils.Constants;
import com.zpjr.cunguan.common.utils.UncaughtException;
import com.zpjr.cunguan.ui.activity.main.MainActivity;

import java.util.Stack;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/5 16:37
 */

public class MyApplication extends Application {

    /**
     * 是否登录
     */
    public static boolean IS_LOGIN = false;

    private static Stack<Activity> activityStack;
    private static MyApplication singleton;
    private UncaughtException mUncaughtException;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        //全局异常捕获初始化
        mUncaughtException = UncaughtException.getInstance();
        mUncaughtException.init(getApplicationContext(),true);
        //获取登录状态
        IS_LOGIN = SharedPreferenceCache.getInstance().getPres("IsLogin").equals("0") ? false : true;
    }

    public static MyApplication getInstance() {
        return singleton;
    }

    /**
     * 把Activity添加到栈中
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
        Log.i(MyApplication.class.getName(), "当前回退栈的Activity数量:" + activityStack.size());
    }

    /**
     * 是否存在Activity
     *
     * @return
     * @param activityName
     */
    public boolean isExistActivity(String activityName) {
        for (Activity a : activityStack) {
            if (a.getClass().getName().equals(activityName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取当前Activity
     *
     * @return
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity
     */
    public void finishCurrentActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity 根据activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定的Activity
     *
     * @param cls 根据类名
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出App
     */
    public void ExitApp() {
        try {
            finishAllActivity();
        } catch (Exception e) {
        }
    }

}
