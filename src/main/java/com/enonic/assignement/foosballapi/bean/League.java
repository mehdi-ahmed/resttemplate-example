package com.enonic.assignement.foosballapi.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League implements Serializable {

    private String id;
    private String name;
    private List<LeaguePlayers> leaguePlayers;
    private List<LeagueTeams> LeagueTeams;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LeaguePlayers> getLeaguePlayers() {
        return leaguePlayers;
    }

    public void setLeaguePlayers(List<LeaguePlayers> leaguePlayers) {
        this.leaguePlayers = leaguePlayers;
    }

    public List<com.enonic.assignement.foosballapi.bean.LeagueTeams> getLeagueTeams() {
        return LeagueTeams;
    }

    public void setLeagueTeams(List<com.enonic.assignement.foosballapi.bean.LeagueTeams> leagueTeams) {
        LeagueTeams = leagueTeams;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", League.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("leaguePlayers=" + leaguePlayers)
                .add("LeagueTeams=" + LeagueTeams)
                .add("leagueTeams=" + getLeagueTeams())
                .toString();
    }
}
