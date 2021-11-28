package com.example.asus.mobilku.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.mobilku.DetailActivity;
import com.example.asus.mobilku.Model.DetailResource;
import com.example.asus.mobilku.Model.ListKendaraanResource;
import com.example.asus.mobilku.R;

import java.util.List;

public class ListKendaraanAdapter extends RecyclerView.Adapter<ListKendaraanAdapter.KendaraanViewHolder>{

    Context context;
    List<ListKendaraanResource> kendaraan;

    public ListKendaraanAdapter(Context context, List<ListKendaraanResource> kendaraan){
        this.context = context;
        this.kendaraan = kendaraan;
    }

    @NonNull
    @Override
    public KendaraanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutList = LayoutInflater.from(context).inflate(R.layout.item_list_kendaraan, parent, false);
        KendaraanViewHolder kendaraanViewHolder = new KendaraanViewHolder(layoutList);

        return kendaraanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KendaraanViewHolder holder, final int position) {

        Glide.with(context)
                .load("http://192.168.1.86/tugasakhir/public/uploads/file/"+kendaraan.get(position).getGambar().toString())
                .into(holder.gambarKendaraan);
        holder.namaKendaraan.setText(kendaraan.get(position).getNamaKendaraan().toString());
        holder.jenisKendaraan.setText(kendaraan.get(position).getJenis().toString());
        holder.namaPerusahaan.setText(kendaraan.get(position).getNama().toString());
        holder.hargaKendaraan.setText(kendaraan.get(position).getHarga().toString());

        holder.cardKedaraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("id_kendaraan", kendaraan.get(position).getIdKendaraan().toString());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kendaraan.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class KendaraanViewHolder extends RecyclerView.ViewHolder {

        ImageView gambarKendaraan;
        TextView namaKendaraan, jenisKendaraan, namaPerusahaan, hargaKendaraan;
        CardView cardKedaraan;

        public KendaraanViewHolder(final View itemView) {
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
