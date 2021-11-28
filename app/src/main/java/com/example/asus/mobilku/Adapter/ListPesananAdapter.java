package com.example.asus.mobilku.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.mobilku.Interface.ListPesananInterface;
import com.example.asus.mobilku.Model.ListPesananResource;
import com.example.asus.mobilku.R;

import java.util.List;

public class ListPesananAdapter extends RecyclerView.Adapter<ListPesananAdapter.PesananViewHolder> {

    Context context;
    List<ListPesananResource> pesanan;

    public ListPesananAdapter(Context context, List<ListPesananResource> pesanan){

        this.context = context;
        this.pesanan = pesanan;

    }

    @NonNull
    @Override
    public PesananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutList = LayoutInflater.from(context).inflate(R.layout.item_list_pesanan, parent, false);
        ListPesananAdapter.PesananViewHolder pesananViewHolder = new ListPesananAdapter.PesananViewHolder(layoutList);

        return pesananViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PesananViewHolder holder, int position) {

        holder.txtNo.setText("No. Pesanan : "+pesanan.get(position).getIdPemesanan().toString());
        holder.txtHarga.setText("Rp. "+pesanan.get(position).getHarga().toString());
        holder.txtNamaKendaraan.setText(pesanan.get(position).getNamaKendaraan().toString());
        holder.txtPerusahaan.setText(pesanan.get(position).getNama().toString());
        holder.txtAlamat.setText(pesanan.get(position).getAlamat().toString());
        holder.txtTanggal.setText(pesanan.get(position).getTanggalKeluar().toString());

    }

    @Override
    public int getItemCount() {
        return pesanan.size();
    }

    public class PesananViewHolder extends RecyclerView.ViewHolder {

        TextView txtNo, txtHarga, txtNamaKendaraan, txtPerusahaan, txtAlamat, txtTanggal;

        public PesananViewHolder(View itemView) {
            super(itemView);

            txtNo = itemView.findViewById(R.id.text_no_pesanan);
            txtHarga = itemView.findViewById(R.id.text_harga);
            txtNamaKendaraan = itemView.findViewById(R.id.nama_kendaraan);
            txtPerusahaan = itemView.findViewById(R.id.nama_perusahaan);
            txtAlamat = itemView.findViewById(R.id.alamat);
            txtTanggal = itemView.findViewById(R.id.tanggal_sewa);

        }
    }
}
