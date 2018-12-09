package com.enonic.assignement.foosballapi.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats implements Serializable {

    private long gameCount;
    private long winningGameCount;
    private long goalCount;

    public long getGameCount() {
        return gameCount;
    }

    public long getWinningGameCount() {
        return winningGameCount;
    }

    public long getGoalCount() {
        return goalCount;
    }

    public void setGameCount(long gameCount) {
        this.gameCount = gameCount;
    }

    public void setWinningGameCount(long winningGameCount) {
        this.winningGameCount = winningGameCount;
    }

    public void setGoalCount(long goalCount) {
        this.goalCount = goalCount;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "gameCount=" + gameCount +
                ", winningGameCount=" + winningGameCount +
                ", goalCount=" + goalCount +
                '}';
    }
}
