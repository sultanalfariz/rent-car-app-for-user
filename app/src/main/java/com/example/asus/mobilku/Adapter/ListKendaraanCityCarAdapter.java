package com.example.asus.mobilku.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.mobilku.DetailActivity;
import com.example.asus.mobilku.Model.FilterCityCarResource;
import com.example.asus.mobilku.R;

import java.util.List;

public class ListKendaraanCityCarAdapter extends RecyclerView.Adapter<ListKendaraanCityCarAdapter.KendaraanFilterViewHolder>{

    Context context;
    List<FilterCityCarResource> filterKendaraan;

    public ListKendaraanCityCarAdapter(Context context, List<FilterCityCarResource> filterKendaraan){
        this.context = context;
        this.filterKendaraan = filterKendaraan;
    }

    @NonNull
    @Override
    public KendaraanFilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutList = LayoutInflater.from(context).inflate(R.layout.item_list_kendaraan, parent, false);
        KendaraanFilterViewHolder kendaraanViewHolder = new KendaraanFilterViewHolder(layoutList);

        return kendaraanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KendaraanFilterViewHolder holder, final int position) {

        Glide.with(context)
                .load("http://192.168.1.86/tugasakhir/public/uploads/file/"+filterKendaraan.get(position).getGambar().toString())
                .into(holder.gambarKendaraan);
        holder.namaKendaraan.setText(filterKendaraan.get(position).getNamaKendaraan().toString());
        holder.jenisKendaraan.setText(filterKendaraan.get(position).getJenis().toString());
        holder.namaPerusahaan.setText(filterKendaraan.get(position).getNamaKendaraan().toString());
        holder.hargaKendaraan.setText(filterKendaraan.get(position).getHarga().toString());

        holder.cardKedaraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("id_kendaraan", filterKendaraan.get(position).getIdKendaraan().toString());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filterKendaraan.size();
    }

    public class KendaraanFilterViewHolder extends RecyclerView.ViewHolder {

        ImageView gambarKendaraan;
        TextView namaKendaraan, jenisKendaraan, namaPerusahaan, hargaKendaraan;
        CardView cardKedaraan;

        public KendaraanFilterViewHolder(View itemView) {
            super(itemView);

            gambarKendaraan = itemView.findViewById(R.id.gambar_kendaraan);
            namaKendaraan = itemView.findViewById(R.id.nama_kendaraan);
            jenisKendaraan = itemView.findViewById(R.id.jenis_kendaraan);
            namaPerusahaan = itemView.findViewById(R.id.nama_perusahaan);
            hargaKendaraan = itemView.findViewById(R.id.harga_kenndaraan);
            cardKedaraan = itemView.findViewById(R.id.card_kendaraan);

        }
    }
}
