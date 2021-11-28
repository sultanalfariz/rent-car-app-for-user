package com.example.asus.mobilku;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.asus.mobilku.Fragment.KendaraanFragment;
import com.example.asus.mobilku.Fragment.LainnyaFragment;
import com.example.asus.mobilku.Fragment.PencarianFragment;
import com.example.asus.mobilku.Fragment.PesananFragment;

public class MainActivity extends AppCompatActivity {

    RelativeLayout btnKendaraan, btnPesanan, btnCari, btnLainnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKendaraan = findViewById(R.id.btnKendaraan);
        btnPesanan = findViewById(R.id.btnPesanan);
        btnCari = findViewById(R.id.btnCari);
        btnLainnya = findViewById(R.id.btnLain);

        btnKendaraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new KendaraanFragment());
            }
        });

        btnPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new PesananFragment());
            }
        });

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new PencarianFragment());
            }
        });

        btnLainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new LainnyaFragment());
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new KendaraanFragment()).commit();
        }

    }

    private void  loadFragment(Fragment fragment){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {

    }

}
