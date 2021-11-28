package com.example.asus.mobilku.Interface;

import com.example.asus.mobilku.Model.ListPesananResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListPesananInterface {

    @GET("pemesanan_user_by_id/{id}")
    Call<ListPesananResponse> pesanan(@Path("id") String id);

}
