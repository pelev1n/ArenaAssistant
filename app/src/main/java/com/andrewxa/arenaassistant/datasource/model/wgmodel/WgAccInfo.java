package com.andrewxa.arenaassistant.datasource.model.wgmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WgAccInfo {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("meta")
    @Expose
    private Meta meta;

    @SerializedName("data")
    @Expose
    private List<Data> data;

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public Meta getMeta() { return meta; }
    public void setMeta(Meta value) { this.meta = value; }

    public List<Data> getData() { return data; }
    public void setData(List<Data> value) { this.data = value; }


}