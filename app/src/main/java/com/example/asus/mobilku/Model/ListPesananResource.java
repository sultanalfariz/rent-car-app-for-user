package com.example.asus.mobilku.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListPesananResource {

    @SerializedName("id_pemesanan")
    @Expose
    private Integer idPemesanan;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("nama_kendaraan")
    @Expose
    private String namaKendaraan;
    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("tanggal_keluar")
    @Expose
    private String tanggalKeluar;

    public Integer getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(Integer idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

}
