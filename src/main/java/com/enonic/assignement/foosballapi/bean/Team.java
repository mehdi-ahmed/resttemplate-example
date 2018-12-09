package com.enonic.assignement.foosballapi.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team implements Serializable {

    private String id;
    private String name;
    private Stats stats;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Stats getStats() {
        return stats;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stats=" + stats +
                '}';
    }
}
