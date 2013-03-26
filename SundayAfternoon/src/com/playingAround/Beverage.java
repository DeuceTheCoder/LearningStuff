package com.playingAround;

import org.springframework.stereotype.Component;

public abstract class Beverage {
    private double ABV;

    public double getABV() {
        return ABV;
    }

    public void setABV(double ABV) {
        this.ABV = ABV;
    }

}
