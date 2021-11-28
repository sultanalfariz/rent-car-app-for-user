package com.example.asus.mobilku.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddPemesananResponse {

    @SerializedName("success")
    @Expose
    private AddPemesananResource addPemesananResource;

    public AddPemesananResource getSuccess() {
        return addPemesananResource;
    }

    public void setSuccess(AddPemesananResource addPemesananResource) {
        this.addPemesananResource = addPemesananResource;
    }

}
