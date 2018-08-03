package com.andrewxa.arenaassistant.datasource.model.arenamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Map {

    @SerializedName("commander_key")
    @Expose
    private String mapName;

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

    public String getMapName() { return mapName; }
    public void setMapName(String value) { this.mapName = value; }

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
}
