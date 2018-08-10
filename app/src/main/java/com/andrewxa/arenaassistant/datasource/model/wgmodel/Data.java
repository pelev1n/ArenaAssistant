package com.andrewxa.arenaassistant.datasource.model.wgmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {


    @SerializedName("nickname")
    @Expose
    private String nickname;

    @SerializedName("account_id")
    @Expose
    private long accountID;

    public String getNickname() { return nickname; }
    public void setNickname(String value) { this.nickname = value; }

    public long getAccountID() { return accountID; }
    public void setAccountID(long value) { this.accountID = value; }

    public String getAccountIDString()  {
        return Long.toString(accountID);
    }

    @Override
    public String toString() {
        return nickname +  Long.toString(accountID);
    }
}
