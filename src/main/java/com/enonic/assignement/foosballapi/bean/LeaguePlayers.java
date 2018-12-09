package com.enonic.assignement.foosballapi.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaguePlayers implements Serializable {

    private String id;
    private long rating;
    private long ranking;
    private Player player;

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "LeaguePlayers{" +
                "id='" + id + '\'' +
                ", rating=" + rating +
                ", ranking=" + ranking +
                ", player=" + player +
                '}';
    }
}
