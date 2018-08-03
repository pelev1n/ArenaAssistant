package com.andrewxa.arenaassistant.datasource.model.arenamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BattleResult {

    @SerializedName("timestamp")
    @Expose
    private long timestamp;

    @SerializedName("id")
    @Expose
    private String id;

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long value) { this.timestamp = value; }

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }
}
