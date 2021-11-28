package com.example.asus.mobilku.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListKendaraanResponse {

    @SerializedName("success")
    @Expose
    private List<ListKendaraanResource> listKendaraanResource = null;

    public List<ListKendaraanResource> getSuccess() {
        return listKendaraanResource;
    }

    public void setSuccess(List<ListKendaraanResource> listKendaraanResource) {
        this.listKendaraanResource = listKendaraanResource;
    }

}
