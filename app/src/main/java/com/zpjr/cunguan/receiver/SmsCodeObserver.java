package com.zpjr.cunguan.receiver;

import android.database.ContentObserver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Description:      自动填写验证码观察类
 * Autour：          LF
 * Date：            2017/8/1 16:01
 */

public class SmsCodeObserver extends ContentObserver {

    private Context context;
    private Handler handler;
    private String compileValue;

    /**
     * @param context
     *            上下文对象
     * @param handler
     *            handler对象,需要把code发送回去
     * @param codeLength
     *            验证码的长度,一个数字
     */
    public SmsCodeObserver(Context context, Handler handler, int codeLength) {
        super(handler);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.handler = handler;
        compileValue = "\\d{" + codeLength + "}";
    }

    // 收到短信一般来说都是执行了两次onchange方法.第一次一般都是raw的这个.这个时候虽然收到了短信.但是短信还没有写入到收件箱里面
    // 然后才是另外一个,后面的数字是该短信在收件箱中的位置
    @Override
    public void onChange(boolean selfChange, Uri uri) {
        Log.e("smsobserver", "selfChange:" + selfChange + "Uri:" + uri.toString());

        if (uri.toString().equals("content://sms/raw")) {
            return;
        }

        // 降序查询我们的数据库
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String body = cursor.getString(cursor.getColumnIndex("body"));
                Log.e("smsobserver", "get sms:address:" + address + "body:" + body);
                cursor.close();// 最后用完游标千万记得关闭

                 if (!address.equals("13676900000")) {
                 return;
                 }

                // 正则表达式的使用,从一段字符串中取出六位连续的数字
                Pattern pattern = Pattern.compile(compileValue);
                Matcher matcher = pattern.matcher(body);
                if (matcher.find()) {
                    // String
                    Log.e("smsobserver", "code:" + matcher.group(0));
                    Log.e("smsobserver", "contentObserver get code time:" + System.currentTimeMillis());

                    // 利用handler将得到的验证码发送给主界面
                    Message msg = Message.obtain();
                    msg.what = 0;
                    msg.obj = matcher.group(0);
                    handler.sendMessage(msg);
                }
            }
        }
    }
}
