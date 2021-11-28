package com.example.asus.mobilku.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.mobilku.Adapter.ListPesananAdapter;
import com.example.asus.mobilku.Config;
import com.example.asus.mobilku.Interface.ListPesananInterface;
import com.example.asus.mobilku.Model.ListPesananResource;
import com.example.asus.mobilku.Model.ListPesananResponse;
import com.example.asus.mobilku.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesananFragment extends Fragment {

    RecyclerView rvListPesanan;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    List<ListPesananResource> pesanan = new ArrayList<>();

    public PesananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View listpesanan = inflater.inflate(R.layout.fragment_pesanan, container, false);

        rvListPesanan = listpesanan.findViewById(R.id.rv_list_pesanan);

        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_user", null);
        Log.d("dataaaa", "id = "+id);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvListPesanan.setLayoutManager(linearLayoutManager);

        ListPesananInterface listPesananInterface = Config.getClient(getContext()).create(ListPesananInterface.class);
        Call<ListPesananResponse> listPesanan = listPesananInterface.pesanan(id);
        listPesanan.enqueue(new Callback<ListPesananResponse>() {
            @Override
            public void onResponse(Call<ListPesananResponse> call, Response<ListPesananResponse> response) {

                pesanan = response.body().getSuccess();

                if (pesanan != null){

                    ListPesananAdapter listPesananAdapter = new ListPesananAdapter(getContext(), pesanan);
                    rvListPesanan.setAdapter(listPesananAdapter);
                    listPesananAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<ListPesananResponse> call, Throwable t) {

            }
        });

        return listpesanan;

    }

}
