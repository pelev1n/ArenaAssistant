package com.andrewxa.arenaassistant.datasource.model.arenamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Total {

    @SerializedName("kills")
    @Expose
    private long kills;

    @SerializedName("free_xp_cents")
    @Expose
    private long freeXPCents;

    @SerializedName("silver_cents")
    @Expose
    private long silverCents;

    @SerializedName("unit_xp_cents")
    @Expose
    private long unitXPCents;

    @SerializedName("battle_points_cents")
    @Expose
    private long battlePointsCents;

    @SerializedName("battles_played")
    @Expose
    private long battlesPlayed;

    @SerializedName("damage")
    @Expose
    private long damage;

    @SerializedName("faction_results")
    @Expose
    private List<FactionResult> factionResults;

    @SerializedName("commander_results")
    @Expose
    private List<CommanderResult> commanderResults;

    @SerializedName("results")
    @Expose
    private Result results;


    public long getKills() { return kills; }
    public void setKills(long value) { this.kills = value; }

    public long getFreeXPCents() { return freeXPCents; }
    public void setFreeXPCents(long value) { this.freeXPCents = value; }

    public long getSilverCents() { return silverCents; }
    public void setSilverCents(long value) { this.silverCents = value; }

    public long getUnitXPCents() { return unitXPCents; }
    public void setUnitXPCents(long value) { this.unitXPCents = value; }

    public long getBattlePointsCents() { return battlePointsCents; }
    public void setBattlePointsCents(long value) { this.battlePointsCents = value; }

    public long getBattlesPlayed() { return battlesPlayed; }
    public void setBattlesPlayed(long value) { this.battlesPlayed = value; }

    public long getDamage() { return damage; }
    public void setDamage(long value) { this.damage = value; }

    public List<FactionResult> getFactionResults() { return factionResults; }
    public void setFactionResults(List<FactionResult> value) { this.factionResults = value; }

    public List<CommanderResult> getCommanderResults() { return commanderResults; }
    public void setCommanderResults(List<CommanderResult> value) { this.commanderResults = value; }

    public Result getResults() { return results; }
    public void setResults(Result value) { this.results = value; }
}
