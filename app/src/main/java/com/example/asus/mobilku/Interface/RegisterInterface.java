package com.example.asus.mobilku.Interface;

import com.example.asus.mobilku.Model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterInterface {

    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse> register(@Field("nama") String nama,
                                    @Field("no_ktp_user") String no_ktp_user,
                                    @Field("alamat") String alamat,
                                    @Field("no_telp_user") String no_telp_user,
                                    @Field("email") String email,
                                    @Field("password") String password);

}
