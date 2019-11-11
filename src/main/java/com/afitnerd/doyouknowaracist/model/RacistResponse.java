package com.afitnerd.doyouknowaracist.model;

public class RacistResponse {

    private Racist racist;

    public RacistResponse(Racist racist) {
        this.racist = racist;
    }

    public Racist getRacist() {
        return racist;
    }

    public void setRacist(Racist racist) {
        this.racist = racist;
    }
}
