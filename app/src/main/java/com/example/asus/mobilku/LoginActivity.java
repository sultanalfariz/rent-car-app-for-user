package com.example.asus.mobilku;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.mobilku.Fragment.KendaraanFragment;
import com.example.asus.mobilku.Interface.LoginInterface;
import com.example.asus.mobilku.Model.LoginResource;
import com.example.asus.mobilku.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText formEmail;
    EditText formPassword;
    TextView btnLogin;
    RelativeLayout btnRegister;

    String email, password;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(KEYPREF, Context.MODE_PRIVATE);

        formEmail = findViewById(R.id.input_email);
        formPassword = findViewById(R.id.input_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = formEmail.getText().toString();
                password = formPassword.getText().toString();

                LoginInterface loginInterface = Config.getClient(LoginActivity.this)
                        .create(LoginInterface.class);

                Call<LoginResponse> login = loginInterface.login(email, password);
                login.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Log.d("dataaa", "masuk response");
                        LoginResponse status = response.body().getSuccess();
                        LoginResource dataUser = response.body().getSuccess();
                        String id_user = String.valueOf(dataUser.getId());
                        if (status != null){

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            SharedPreferences.Editor data = sharedPreferences.edit();
                            data.putString("id_user", id_user);
                            data.commit();
                            data.apply();
                            startActivity(intent);

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Email atau Password Anda Salah",
                                Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
