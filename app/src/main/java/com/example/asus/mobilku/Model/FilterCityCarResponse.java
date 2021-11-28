package com.example.asus.mobilku.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilterCityCarResponse {

    @SerializedName("success")
    @Expose
    private List<FilterCityCarResource> filterCityCarResource = null;

    public List<FilterCityCarResource> getSuccess() {
        return filterCityCarResource;
    }

    public void setSuccess(List<FilterCityCarResource> filterCityCarResource) {
        this.filterCityCarResource = filterCityCarResource;
    }


}
