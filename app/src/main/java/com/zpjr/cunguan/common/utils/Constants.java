package com.zpjr.cunguan.common.utils;

import android.os.Environment;

/**
 * Description:      常量配置类
 * Autour：          LF
 * Date：            2017/7/11 15:19
 */

public class Constants {

    /******************************生产环境配置******************************/
    /**
     * 服务器地址
     */
    public static String SERVER_URL = "http://bank.zp-bank.com/api/v2/";

    /**
     * 注册验证验证码请求地址
     */
    public static String BASE_URL = "https://bank.zp-bank.com/";

    public static String CLIENT_ID = "509925fb-9616-4e77-9922-03c2b04cc46e";

    public static String CLIENT_SECRET = "984d62a0a44f2d1dcf47d71117f7ab4c75c612de10da2a7de96cc7efb343bfc9";

    /****************************测试环境配置******************************/
    /**
     * 测试地址
     */
//    public static String SERVER_URL = "http://192.168.66.246/api/v2/";
//
//    public static String BASE_URL = "http://192.168.66.246/";
//
//    public static String CLIENT_ID = "client-id-for-mobile-dev";
//
//    public static String CLIENT_SECRET = "client-secret-for-mobile-dev";
    /****************************华丽分割线******************************/


    public static String GRANT_TYPE = "password";


    public static String CLIENT_CODE = "手机用户";

    /**
     * 请求失败分类
     */
    public static String NETWORK_NO = "无网络可用";
    public static String NETWORK_NOT_WORK = "当前网络不可用";
    public static String TIMEOUT_ERROR = "链接超时";
    public static String CONNECT_NOT_ERROR = "无法链接网路";
    public static String JSON_SYNTAX_ERROR = "Json解析失败";
    public static String CONNECT_FAIL = "请求失败";

    /**
     * 中平金融的默认文件夹路径
     */
    public static String APP_SDCARD_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/zpjr";

    /**
     * 分页数
     */
    public static String PAGE_SIZE = "10";

    /**
     * 分页--显示没有更多数据
     */
    public static String NO_MORE_DATA = "没有更多数据";

    /**
     * 短期速盈
     */
    public static String ASY = "ASY";
    /**
     * 中期易盈
     */
    public static String PYY = "PYY";
    /**
     * 长期稳盈
     */
    public static String AWY = "AWY";
}
