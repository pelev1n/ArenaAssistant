package com.andrewxa.arenaassistant.datasource.model.arenamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArenaAccInfo {
    @SerializedName("user_id")
    @Expose
    private String userID;

    @SerializedName("join_date")
    @Expose
    private long joinDate;

    @SerializedName("players_level")
    @Expose
    private long playersLevel;

    @SerializedName("public")
    @Expose
    private String arenaPublic;

    @SerializedName("last_updated")
    @Expose
    private long lastUpdated;

    @SerializedName("battle_results")
    @Expose
    private List<BattleResult> battleResults;

    @SerializedName("stats")
    @Expose
    private List<Stat> stats;

    @SerializedName("totals")
    @Expose
    private Total totals;

    @SerializedName("eagles")
    @Expose
    private List<Object> eagles;

    @SerializedName("max_eagles")
    @Expose
    private List<Object> maxEagles;

    @SerializedName("achievements")
    @Expose
    private List<Achievement> achievements;

    public String getUserID() { return userID; }
    public void setUserID(String value) { this.userID = value; }

    public long getJoinDate() { return joinDate; }
    public void setJoinDate(long value) { this.joinDate = value; }

    public long getPlayersLevel() { return playersLevel; }
    public void setPlayersLevel(long value) { this.playersLevel = value; }

    public String getArenaPublic() { return arenaPublic; }
    public void setArenaPublic(String value) { this.arenaPublic = value; }

    public long getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(long value) { this.lastUpdated = value; }

    public List<BattleResult> getBattleResults() { return battleResults; }
    public void setBattleResults(List<BattleResult> value) { this.battleResults = value; }

    public List<Stat> getStats() { return stats; }
    public void setStats(List<Stat> value) { this.stats = value; }

    public Total getTotals() { return totals; }
    public void setTotals(Total value) { this.totals = value; }

    public List<Object> getEagles() { return eagles; }
    public void setEagles(List<Object> value) { this.eagles = value; }

    public List<Object> getMaxEagles() { return maxEagles; }
    public void setMaxEagles(List<Object> value) { this.maxEagles = value; }

    public List<Achievement> getAchievements() { return achievements; }
    public void setAchievements(List<Achievement> value) { this.achievements = value; }
}
