package com.ezooma.caterer.app.rest;


import com.ezooma.caterer.app.rest.dto.ResponseDto;

import java.util.Map;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIClientInterface {
    String BASE_URL = "http://ec2-3-8-133-204.eu-west-2.compute.amazonaws.com/catering/User/";

    @POST("getCategories")
    Call<ResponseDto> getCategories();

    @POST("getServices")
    Call<ResponseDto> getServicesAndDays();

    @POST("notifications")
    @FormUrlEncoded
    Call<ResponseDto> notificationApi(@FieldMap Map<String, Object> params);


    @POST("registeration")
    @FormUrlEncoded
    Call<ResponseDto> registerApi(@FieldMap Map<String, Object> params);

    @POST("login")
    @FormUrlEncoded
    Call<ResponseDto> loginApi(@FieldMap Map<String, Object> params);

    @POST("getProfile")
    @FormUrlEncoded
    Call<ResponseDto> getProfile(@FieldMap Map<String, Object> params);

    @POST("setProfile")
    @FormUrlEncoded
    Call<ResponseDto> setProfile(@FieldMap Map<String, Object> params);

    @POST("changePassword")
    @FormUrlEncoded
    Call<ResponseDto> changePassword(@FieldMap Map<String, Object> params);


    @POST("forgotPassword")
    @FormUrlEncoded
    Call<ResponseDto> getWinesPdf(@FieldMap Map<String, Object> params);

    @POST("getVersionDetail")
    Call<ResponseDto> getAppVersion();
}
