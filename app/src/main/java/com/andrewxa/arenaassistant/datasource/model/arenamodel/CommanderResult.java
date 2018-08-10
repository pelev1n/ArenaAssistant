package com.andrewxa.arenaassistant.datasource.model.arenamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommanderResult {


    @SerializedName("victories")
    @Expose
    private long victories;

    @SerializedName("defeats")
    @Expose
    private long defeats;

    @SerializedName("draws")
    @Expose
    private long draws;

    public long getVictories() { return victories; }
    public void setVictories(long value) { this.victories = value; }

    public long getDefeats() { return defeats; }
    public void setDefeats(long value) { this.defeats = value; }

    public long getDraws() { return draws; }
    public void setDraws(long value) { this.draws = value; }
}
