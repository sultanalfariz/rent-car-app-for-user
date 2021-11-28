package com.example.asus.mobilku.Interface;

import com.example.asus.mobilku.Model.ListKendaraanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListKendaraanInterface {

    @GET("tampil_kendaraan")
    Call<ListKendaraanResponse> kendaraan();

}
