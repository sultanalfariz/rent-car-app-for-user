package com.example.asus.mobilku.Interface;

import com.example.asus.mobilku.Model.DetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DetailInterface {

    @GET("detail_kendaraan/{id}")
    Call<DetailResponse> detail(@Path("id") String id);

}
