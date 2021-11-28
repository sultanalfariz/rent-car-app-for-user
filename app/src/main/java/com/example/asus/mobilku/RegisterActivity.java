package com.example.asus.mobilku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.mobilku.Interface.RegisterInterface;
import com.example.asus.mobilku.Model.RegisterResource;
import com.example.asus.mobilku.Model.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText formNama, formNo_ktp, formAlamat, formNo_telp, formEmail, formPassword;
    TextView btnDaftar;

    String nama, no_ktp_user, alamat, no_telp_user, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        formNama = findViewById(R.id.form_nama);
        formNo_ktp = findViewById(R.id.form_ktp);
        formAlamat = findViewById(R.id.form_alamat);
        formNo_telp = findViewById(R.id.form_telpon);
        formEmail = findViewById(R.id.form_email);
        formPassword = findViewById(R.id.form_password);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = formNama.getText().toString();
                no_ktp_user = formNo_ktp.getText().toString();
                alamat = formAlamat.getText().toString();
                no_telp_user = formNo_telp.getText().toString();
                email = formEmail.getText().toString();
                password = formPassword.getText().toString();

                RegisterInterface registerInterface = Config.getClient(RegisterActivity.this)
                        .create(RegisterInterface.class);

                Call<RegisterResponse> register = registerInterface
                        .register(nama, no_ktp_user, alamat, no_telp_user, email, password);
                register.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        RegisterResponse status = response.body().getSuccess();
                        if (status != null){
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Isi Data Anda Dengan Benar",
                                Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}
