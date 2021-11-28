package com.example.asus.mobilku.Interface;

import com.example.asus.mobilku.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {

    @FormUrlEncoded
    @POST("login_user")
    Call<LoginResponse> login(@Field ("email") String email,
                              @Field("password") String password);

}
