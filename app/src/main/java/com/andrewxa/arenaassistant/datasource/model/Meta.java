package com.andrewxa.arenaassistant.datasource.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("count")
    @Expose
    private long count;

    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }

    @Override
    public String toString() {
        return Long.toString(count);
    }
}
