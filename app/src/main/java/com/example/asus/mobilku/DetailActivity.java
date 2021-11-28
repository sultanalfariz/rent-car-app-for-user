package com.example.asus.mobilku;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.mobilku.Interface.DetailInterface;
import com.example.asus.mobilku.Model.DetailResource;
import com.example.asus.mobilku.Model.DetailResponse;
import com.example.asus.mobilku.Model.LoginResource;
import com.example.asus.mobilku.Model.LoginResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    ImageView gambarKendaraan;
    TextView txtNama, txtPerusahaan, txtAlamat, txtHarga;
    RelativeLayout btnLanjut;

    List<DetailResource> detail = new ArrayList<>();
    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        gambarKendaraan = findViewById(R.id.gambar_kendaraan);
        txtNama = findViewById(R.id.nama_kendaraan);
        txtPerusahaan = findViewById(R.id.nama_perusahaan);
        txtAlamat = findViewById(R.id.alamat_rent);
        txtHarga = findViewById(R.id.text_info_harga);
        btnLanjut = findViewById(R.id.btn_lanjutkan);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id_kendaraan");
        Log.d("dataaaaa", "id_kendaraan = "+id);
        sharedPreferences = getSharedPreferences(KEYPREF, MODE_PRIVATE);
        SharedPreferences.Editor data = sharedPreferences.edit();
        data.putString("id_kendaraan", id);
        data.commit();
        data.apply();

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, PemesananActivity.class);
                intent.putExtra("id_perusahaan", detail.get(0).getIdPerusahaan().toString());
                startActivity(intent);
            }
        });

        DetailInterface detailInterface = Config.getClient(DetailActivity.this)
                .create(DetailInterface.class);
        Call<DetailResponse> detaikKendaraan = detailInterface.detail(id);
        detaikKendaraan.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                Log.d("dataaaaa", "masuk response");
                detail = response.body().getSuccess();
                Log.d("dataaaaa", "data = "+detail);
                if (detail != null){

                    Glide.with(DetailActivity.this)
                            .load("http://192.168.1.86/tugasakhir/public/uploads/file/"+detail.get(0).getGambar().toString())
                            .into(gambarKendaraan);
                    txtNama.setText(detail.get(0).getNamaKendaraan().toString());
                    txtPerusahaan.setText(detail.get(0).getNama().toString());
                    txtAlamat.setText(detail.get(0).getAlamat().toString());
                    txtHarga.setText(detail.get(0).getHarga().toString());

                }

            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {

            }
        });

    }
}
