package com.bawei.applications;

import com.bawei.applications.model.bean.LoginBean;
import com.bawei.applications.model.bean.OrderformBean;
import com.bawei.applications.model.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Time:2020/2/13 0013下午 02:59202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterBean> getRegisterData(@Field("phone") String phone, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> getLoginData(@Field("phone") String phone, @Field("pwd") String pwd);

    @GET("small/order/verify/v1/findOrderListByStatus")
    Observable<OrderformBean> getOrderformData(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("status") int status,@Query("page") int page,@Query("count")int count);
}
