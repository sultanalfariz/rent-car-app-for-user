package com.example.asus.mobilku.Interface;

import com.example.asus.mobilku.Model.AddPemesananResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddPemesananInterface {

    @FormUrlEncoded
    @POST("tambah_pemesanan")
    Call<AddPemesananResponse> tambahPesanan(@Field("nama_kendaraan") String nama_kendaraan,
                                             @Field("tanggal") String tanggal,
                                             @Field("tanggal_keluar") String tanggl_keluar,
                                             @Field("tanggal_masuk") String tanggal_masuk,
                                             @Field("harga") String harga,
                                             @Field("id_user") String id_user,
                                             @Field("id_perusahaan") String id_perusahaan,
                                             @Field("id_kendaraan") String id_kendaraan);

}
