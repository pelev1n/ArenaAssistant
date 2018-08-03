package com.andrewxa.arenaassistant.datasource.model.arenamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reward {

    @SerializedName("reward_type")
    @Expose
    private String rewardType;

    @SerializedName("free_xp_cents")
    @Expose
    private long freeXPCents;

    @SerializedName("unit_xp_cents")
    @Expose
    private long unitXPCents;

    @SerializedName("silver_cents")
    @Expose
    private long silverCents;

    @SerializedName("battle_points_cents")
    @Expose
    private long battlePointsCents;


    public String getRewardType() { return rewardType; }
    public void setRewardType(String value) { this.rewardType = value; }

    public long getFreeXPCents() { return freeXPCents; }
    public void setFreeXPCents(long value) { this.freeXPCents = value; }

    public long getUnitXPCents() { return unitXPCents; }
    public void setUnitXPCents(long value) { this.unitXPCents = value; }

    public long getSilverCents() { return silverCents; }
    public void setSilverCents(long value) { this.silverCents = value; }

    public long getBattlePointsCents() { return battlePointsCents; }
    public void setBattlePointsCents(long value) { this.battlePointsCents = value; }
}
