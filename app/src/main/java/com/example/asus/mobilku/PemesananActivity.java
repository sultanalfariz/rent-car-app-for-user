package com.example.asus.mobilku;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.mobilku.Interface.AddPemesananInterface;
import com.example.asus.mobilku.Model.AddPemesananResource;
import com.example.asus.mobilku.Model.AddPemesananResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PemesananActivity extends AppCompatActivity {

    EditText formNamaKend, formTanggal, formHarga, formTglPakai, formTglSls;
    TextView btnPesan;

    String nama, tanggal, tglSelesai, tglPakai, harga;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferences;

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);

        formNamaKend = findViewById(R.id.form_nama);
        formTanggal = findViewById(R.id.form_ktp);
        formTglPakai = findViewById(R.id.form_alamat);
        formTglSls = findViewById(R.id.form_telpon);
        formHarga = findViewById(R.id.form_harga);
        btnPesan = findViewById(R.id.btn_pesan);

        myDialog = new Dialog(this);

        sharedPreferences = getSharedPreferences(KEYPREF, MODE_PRIVATE);
        final String id = sharedPreferences.getString("id_user", null);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = formNamaKend.getText().toString();
                tanggal = formTanggal.getText().toString();
                tglPakai= formTglPakai.getText().toString();
                tglSelesai = formTglSls.getText().toString();
                harga = formHarga.getText().toString();

                String id_kendaraan = sharedPreferences.getString("id_kendaraan", null);
                String id_perusahaan = getIntent().getStringExtra("id_perusahaan");

                AddPemesananInterface addPemesananInterface = Config.getClient(PemesananActivity.this)
                        .create(AddPemesananInterface.class);
                Log.d("dataaaaaaaaaaaa","data = "+nama);
                Log.d("dataaaaaaaaaaaa","data = "+tanggal);
                Log.d("dataaaaaaaaaaaa","data = "+tglPakai);
                Log.d("dataaaaaaaaaaaa","data = "+tglSelesai);
                Log.d("dataaaaaaaaaaaa","data = "+harga);
                Log.d("dataaaaaaaaaaaa","data = "+id_kendaraan);
                Log.d("dataaaaaaaaaaaa","data = "+id_perusahaan);
                Call<AddPemesananResponse> addPesan = addPemesananInterface.tambahPesanan(nama, tanggal, tglPakai, tglSelesai, harga, id, id_perusahaan, id_kendaraan);
                addPesan.enqueue(new Callback<AddPemesananResponse>() {
                    @Override
                    public void onResponse(Call<AddPemesananResponse> call, Response<AddPemesananResponse> response) {

                        AddPemesananResource data = response.body().getSuccess();

                        if (data != null){

                            Intent intent = new Intent(PemesananActivity.this, MainActivity.class);
                            Toast.makeText(PemesananActivity.this, "Pemesanan anda sedang diproses", Toast.LENGTH_LONG).show();
                            startActivity(intent);

                        }

                    }

                    @Override
                    public void onFailure(Call<AddPemesananResponse> call, Throwable t) {

                    }
                });

            }
        });

    }
}
