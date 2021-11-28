package com.example.asus.mobilku.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListPesananResponse {

    @SerializedName("success")
    @Expose
    private List<ListPesananResource> listPesananResource = null;

    public List<ListPesananResource> getSuccess() {
        return listPesananResource;
    }

    public void setSuccess(List<ListPesananResource> listPesananResource) {
        this.listPesananResource = listPesananResource;
    }

}
