package com.andrewxa.arenaassistant.datasource.model.arenamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Achievement {

    @SerializedName("timestamp")
    @Expose
    private long timestamp;

    @SerializedName("key")
    @Expose
    private String key;

    @SerializedName("times_awarded")
    @Expose
    private long timesAwarded;


    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long value) { this.timestamp = value; }

    public String getKey() { return key; }
    public void setKey(String value) { this.key = value; }

    public long getTimesAwarded() { return timesAwarded; }
    public void setTimesAwarded(long value) { this.timesAwarded = value; }
}
