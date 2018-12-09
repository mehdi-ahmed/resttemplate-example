package com.enonic.assignement.foosballapi.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueTeams implements Serializable {

    private String id;
    private long rating;
    private long ranking;
    private Team team;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getRanking() {
        return ranking;
    }

    public void setRanking(long ranking) {
        this.ranking = ranking;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "LeagueTeams{" +
                "id='" + id + '\'' +
                ", rating=" + rating +
                ", ranking=" + ranking +
                ", team=" + team +
                '}';
    }
}
