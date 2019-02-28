package com.zpjr.cunguan.common.retrofit;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zpjr.cunguan.entity.module.LoanModule;
import com.zpjr.cunguan.entity.module.MovieModule;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Description:      API接口类
 * Autour：          LF
 * Date：            2017/7/5 16:31
 * <p>
 * retrofit注解：
 *
 * @HTTP：可以替代其他方法的任意一种
 * @HTTP(method = "get", path = "users/{user}", hasBody = false)
 * Call<ResponseBody> getFirstBlog(@Path("user") String user);
 * @Url：使用全路径复写baseUrl，适用于非统一baseUrl的场景。
 * @GET Call<ResponseBody> v3(@Url String url);
 * @Streaming:用于下载大文件
 * @Path：URL占位符，用于替换和动态更新,相应的参数必须使用相同的字符串被@Path进行注释
 * @GET("group/{id}/users") Call<ResponseBody> groupList(@Path("id") int groupId);
 * @Query,@QueryMap:查询参数，用于GET查询,需要注意的是@QueryMap可以约定是否需要encode@GET("group/users") Call<List<User>> groupList(@Query("id") int groupId);
 * Call<List<News>> getNews((@QueryMap(encoded=true) Map<String, String> options);
 * @Body:用于POST请求体，将实例对象根据转换方式转换为对应的json字符串参数，这个转化方式是GsonConverterFactory定义的。
 * @POST("add") Call<List<User>> addUser(@Body User user);
 * @Field，@FieldMap:Post方式传递简单的键值对,需要添加@FormUrlEncoded表示表单提交Content-Type:application/x-www-form-urlencoded
 * @FormUrlEncoded
 * @POST("user/edit") Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);
 * @Part，@PartMap：用于POST文件上传其中@Part MultipartBody.Part代表文件，@Part("key") RequestBody代表参数需要添加@Multipart表示支持文件上传的表单，Content-Type: multipart/form-data
 */
public interface IApiSeivice {

    /********************登录模块**********************/
    /**
     * 登录
     */
    @POST("token")
    Call<JsonObject> login(@Body Map<String, String> options);

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("register")
    Call<JsonObject> commitRegister(@FieldMap Map<String, String> options);

    /**
     * 检测号码是否注册过
     */
    @FormUrlEncoded
    @POST("register/check_mobile")
    Call<JsonObject> checkPhoneRegistered(@FieldMap Map<String, String> options);

    /**
     * 修改密码的发送验证码
     */
    @GET("users/smsCaptcha/changePwd")
    Call<JsonObject> getSmsCode(@QueryMap Map<String, String> options);

    /**
     * 非v2接口
     * 注册的发送验证码
     * 此接口使用全路径方式
     */
    @GET
    Call<JsonObject> getRegisterSmsCode(@Url String url, @QueryMap Map<String, String> options);

    /**
     * 检测验证码是否正确
     */
    @FormUrlEncoded
    @POST("auth/verify/captcha")
    Call<JsonObject> checkCode(@FieldMap Map<String, String> options);

    /**
     * 修改密码
     */
    @FormUrlEncoded
    @POST("auth/reset_password/password")
    Call<JsonObject> updatePwd(@FieldMap Map<String, String> options);

    /**
     * 获取图形码
     */
    @GET("register/captcha")
    Call<JsonObject> getImgCode();

    /**
     * 验证图形码
     * 此接口必须使用全路径方式
     */
    @POST
    Call<JsonObject> checkImgCodeIsRight(@Url String url, @Body Map<String, String> options);

    /********************投资-产品模块**********************/

    /**
     * 获取产品列表
     */
    @GET("loans/getLoanWithPage")
    Call<JsonObject> getProductList(@QueryMap Map<String, String> options);

    /**
     * 获取公司营业执照等图片信息
     */
    @GET("loan/{id}/images")
    Call<JsonObject> getCompanyImg(@Path("id") String loanId);

    /********************设置模块**********************/

    /**
     * 获取用户信息
     */
    @GET("user/{userId}/userinfo")
    Call<JsonObject> getUserInfo(@Path("userId") String userId);

    /**
     * 获取是否绑卡信息
     */
    @GET("user/{userId}/fundaccounts")
    Call<JsonArray> getMyCard(@Path("userId") String userId);

    /**
     * 检查更新
     */
    @GET
    Call<JsonObject> checkUpdates(@Url String url);

    /**
     * 获取cms
     */
    @GET("cms/category/HELP/name/{url}")
    Call<JsonArray> getCmsContent(@Path("url") String url);

    /**
     * 获取关于我们
     */
    @GET("cms/category/OTHER/name/{url}")
    Call<JsonArray> getAboutUsContent(@Path("url") String url);

    /**
     * 营销短信订阅
     */
    @POST("user/subscribe/{userId}/{flag}")
    Call<JsonObject> isSubscribeSms(@Path("userId") String userId,@Path("flag") String flag);

    /**
     * 修改银行预留手机号
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("czbank/updateMobile/{userId}")
    Call<JsonObject> changeBankMobile(@QueryMap Map<String, String> options,@Path("userId") String userId);

    /**
     * 获取修改预留手机号的动态验证码
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("czbank/SMSSend")
    Call<JsonObject> getDynamicNumber(@QueryMap Map<String, String> options);
}
