package com.example.asus.mobilku.Interface;

import com.example.asus.mobilku.Model.FilterCityCarResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilterCityCarInterface {

    @GET("filter_jenis/{jenis}")
    Call<FilterCityCarResponse> filterJenis(@Path("jenis") String jenis);

}
