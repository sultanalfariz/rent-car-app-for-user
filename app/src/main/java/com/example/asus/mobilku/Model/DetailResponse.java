package com.example.asus.mobilku.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailResponse {

    @SerializedName("success")
    @Expose
    private List<DetailResource> detailResource = null;

    public List<DetailResource> getSuccess() {
        return detailResource;
    }

    public void setSuccess(List<DetailResource> detailResource) {
        this.detailResource = detailResource;
    }


}
