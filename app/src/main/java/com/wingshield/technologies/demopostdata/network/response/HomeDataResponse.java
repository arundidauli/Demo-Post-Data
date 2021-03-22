package com.wingshield.technologies.demopostdata.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wingshield.technologies.demopostdata.model.HomeData;

import java.util.List;

public class HomeDataResponse {
    @SerializedName("data")
    @Expose
    private List<HomeData> data = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private boolean status;

    public List<HomeData> getData() {
        return data;
    }

    public void setData(List<HomeData> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
