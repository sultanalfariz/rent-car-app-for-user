package com.example.asus.mobilku.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.mobilku.Adapter.ListKendaraanAdapter;
import com.example.asus.mobilku.Adapter.ListKendaraanCityCarAdapter;
import com.example.asus.mobilku.Config;
import com.example.asus.mobilku.Interface.FilterCityCarInterface;
import com.example.asus.mobilku.Interface.ListKendaraanInterface;
import com.example.asus.mobilku.Model.FilterCityCarResource;
import com.example.asus.mobilku.Model.FilterCityCarResponse;
import com.example.asus.mobilku.Model.ListKendaraanResource;
import com.example.asus.mobilku.Model.ListKendaraanResponse;
import com.example.asus.mobilku.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class KendaraanFragment extends Fragment {

    RecyclerView rvListKendaraan;
    TextView btnCityCar, btnAdvCar, btnMinibus;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    List<ListKendaraanResource> kendaraan = new ArrayList<>();

    List<FilterCityCarResource> filterCityCar = new ArrayList<>();


    public KendaraanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View listkendaraan = inflater.inflate(R.layout.fragment_kendaraan, container, false);

        rvListKendaraan = listkendaraan.findViewById(R.id.rv_list_kendaraan);

        btnCityCar = listkendaraan.findViewById(R.id.filter_city_car);
        btnAdvCar = listkendaraan.findViewById(R.id.filter_adventure_car);
        btnMinibus = listkendaraan.findViewById(R.id.filter_minibus);


        btnCityCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnCityCar.setBackgroundResource(R.drawable.bg_pilih_filter);
                btnAdvCar.setBackgroundResource(R.drawable.bg_filter);
                btnMinibus.setBackgroundResource(R.drawable.bg_filter);

                FilterCityCarInterface filterCityCarInterface = Config.getClient(getContext())
                        .create(FilterCityCarInterface.class);
                Call<FilterCityCarResponse> filter = filterCityCarInterface.filterJenis("City car");
                filter.enqueue(new Callback<FilterCityCarResponse>() {
                    @Override
                    public void onResponse(Call<FilterCityCarResponse> call, Response<FilterCityCarResponse> response) {

                        filterCityCar = response.body().getSuccess();

                        if (filterCityCar != null){
                            ListKendaraanCityCarAdapter listKendaraanCityCarAdapter = new ListKendaraanCityCarAdapter(getContext(), filterCityCar);
                            rvListKendaraan.setAdapter(listKendaraanCityCarAdapter);
                            listKendaraanCityCarAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFailure(Call<FilterCityCarResponse> call, Throwable t) {

                    }
                });

            }
        });

        btnAdvCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnAdvCar.setBackgroundResource(R.drawable.bg_pilih_filter);
                btnCityCar.setBackgroundResource(R.drawable.bg_filter);
                btnMinibus.setBackgroundResource(R.drawable.bg_filter);

                FilterCityCarInterface filterCityCarInterface = Config.getClient(getContext())
                        .create(FilterCityCarInterface.class);
                Call<FilterCityCarResponse> filter = filterCityCarInterface.filterJenis("Adventure car");
                filter.enqueue(new Callback<FilterCityCarResponse>() {
                    @Override
                    public void onResponse(Call<FilterCityCarResponse> call, Response<FilterCityCarResponse> response) {

                        filterCityCar = response.body().getSuccess();

                        if (filterCityCar != null){
                            ListKendaraanCityCarAdapter listKendaraanCityCarAdapter = new ListKendaraanCityCarAdapter(getContext(), filterCityCar);
                            rvListKendaraan.setAdapter(listKendaraanCityCarAdapter);
                            listKendaraanCityCarAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFailure(Call<FilterCityCarResponse> call, Throwable t) {

                    }
                });

            }
        });

        btnMinibus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnMinibus.setBackgroundResource(R.drawable.bg_pilih_filter);
                btnAdvCar.setBackgroundResource(R.drawable.bg_filter);
                btnCityCar.setBackgroundResource(R.drawable.bg_filter);

                FilterCityCarInterface filterCityCarInterface = Config.getClient(getContext())
                        .create(FilterCityCarInterface.class);
                Call<FilterCityCarResponse> filter = filterCityCarInterface.filterJenis("Minibus");
                filter.enqueue(new Callback<FilterCityCarResponse>() {
                    @Override
                    public void onResponse(Call<FilterCityCarResponse> call, Response<FilterCityCarResponse> response) {

                        filterCityCar = response.body().getSuccess();

                        if (filterCityCar != null){
                            ListKendaraanCityCarAdapter listKendaraanCityCarAdapter = new ListKendaraanCityCarAdapter(getContext(), filterCityCar);
                            rvListKendaraan.setAdapter(listKendaraanCityCarAdapter);
                            listKendaraanCityCarAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFailure(Call<FilterCityCarResponse> call, Throwable t) {

                    }
                });

            }
        });


        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_user", null);
        Log.d("dataaaa", "id = "+id);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvListKendaraan.setLayoutManager(linearLayoutManager);

        ListKendaraanInterface listKendaraanInterface = Config.getClient(getContext())
                .create(ListKendaraanInterface.class);
        Call<ListKendaraanResponse> listKendaraan = listKendaraanInterface.kendaraan();
        listKendaraan.enqueue(new Callback<ListKendaraanResponse>() {
            @Override
            public void onResponse(Call<ListKendaraanResponse> call, Response<ListKendaraanResponse> response) {
                Log.d("dataaaa", "masuk");
                kendaraan = response.body().getSuccess();
                Log.d("dataaaa", "kendaraan = "+kendaraan);
                if (kendaraan != null){
                    ListKendaraanAdapter listKendaraanAdapter = new ListKendaraanAdapter(getContext(), kendaraan);
                    rvListKendaraan.setAdapter(listKendaraanAdapter);
                    listKendaraanAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<ListKendaraanResponse> call, Throwable t) {

            }
        });

        return listkendaraan;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
