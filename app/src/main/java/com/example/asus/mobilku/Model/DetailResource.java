package com.example.asus.mobilku.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailResource {

    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("nama_kendaraan")
    @Expose
    private String namaKendaraan;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("id_perusahaan")
    @Expose
    private Integer idPerusahaan;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public Integer getIdPerusahaan() {
        return idPerusahaan;
    }

    public void setIdPerusahaan(Integer idPerusahaan) {
        this.idPerusahaan = idPerusahaan;
    }
}
