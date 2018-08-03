package com.andrewxa.arenaassistant.datasource.model.arenamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stat {

    @SerializedName("commander_key")
    @Expose
    private String commanderKey;

    @SerializedName("unit_key")
    @Expose
    private String unitKey;

    @SerializedName("unit_xp_cents")
    @Expose
    private long unitXPCents;

    @SerializedName("max_unit_xp_cents")
    @Expose
    private long maxUnitXPCents;

    @SerializedName("max_kills")
    @Expose
    private long maxKills;

    @SerializedName("kills")
    @Expose
    private long kills;

    @SerializedName("free_xp_cents")
    @Expose
    private long freeXPCents;

    @SerializedName("silver_cents")
    @Expose
    private long silverCents;

    @SerializedName("battle_points_cents")
    @Expose
    private long battlePointsCents;

    @SerializedName("defeats")
    @Expose
    private long defeats;

    @SerializedName("victories")
    @Expose
    private long victories;

    @SerializedName("draws")
    @Expose
    private long draws;

    @SerializedName("unique_defeats")
    @Expose
    private long uniqueDefeats;

    @SerializedName("unique_victories")
    @Expose
    private long uniqueVictories;

    @SerializedName("unique_draws")
    @Expose
    private long uniqueDraws;

    @SerializedName("max_points_cents")
    @Expose
    private long maxPointsCents;

    @SerializedName("time_in_battle")
    @Expose
    private long timeInBattle;

    @SerializedName("last_updated")
    @Expose
    private long lastUpdated;

    @SerializedName("maps")
    @Expose
    private List<Map> maps;

    @SerializedName("rewards")
    @Expose
    private List<Reward> rewards;


    public String getCommanderKey() { return commanderKey; }
    public void setCommanderKey(String value) { this.commanderKey = value; }

    public String getUnitKey() { return unitKey; }
    public void setUnitKey(String value) { this.unitKey = value; }

    public long getUnitXPCents() { return unitXPCents; }
    public void setUnitXPCents(long value) { this.unitXPCents = value; }

    public long getMaxUnitXPCents() { return maxUnitXPCents; }
    public void setMaxUnitXPCents(long value) { this.maxUnitXPCents = value; }

    public long getMaxKills() { return maxKills; }
    public void setMaxKills(long value) { this.maxKills = value; }

    public long getKills() { return kills; }
    public void setKills(long value) { this.kills = value; }

    public long getFreeXPCents() { return freeXPCents; }
    public void setFreeXPCents(long value) { this.freeXPCents = value; }

    public long getSilverCents() { return silverCents; }
    public void setSilverCents(long value) { this.silverCents = value; }

    public long getBattlePointsCents() { return battlePointsCents; }
    public void setBattlePointsCents(long value) { this.battlePointsCents = value; }

    public long getDefeats() { return defeats; }
    public void setDefeats(long value) { this.defeats = value; }

    public long getVictories() { return victories; }
    public void setVictories(long value) { this.victories = value; }

    public long getDraws() { return draws; }
    public void setDraws(long value) { this.draws = value; }

    public long getUniqueDefeats() { return uniqueDefeats; }
    public void setUniqueDefeats(long value) { this.uniqueDefeats = value; }

    public long getUniqueVictories() { return uniqueVictories; }
    public void setUniqueVictories(long value) { this.uniqueVictories = value; }

    public long getUniqueDraws() { return uniqueDraws; }
    public void setUniqueDraws(long value) { this.uniqueDraws = value; }

    public long getMaxPointsCents() { return maxPointsCents; }
    public void setMaxPointsCents(long value) { this.maxPointsCents = value; }

    public long getTimeInBattle() { return timeInBattle; }
    public void setTimeInBattle(long value) { this.timeInBattle = value; }

    public long getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(long value) { this.lastUpdated = value; }

    public List<Map> getMaps() { return maps; }
    public void setMaps(List<Map> value) { this.maps = value; }

    public List<Reward> getRewards() { return rewards; }
    public void setRewards(List<Reward> value) { this.rewards = value; }
}
