package com.playingAround;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ThoughtWorker {
    @Autowired
    @Qualifier("hennessy")
    private Beverage beverage;

    private double inebriation;
    private double efficiency;
    private String name;
    private double workRate;

    public ThoughtWorker(String name) {
        beverage = new Kingfisher();
        this.name = name;
        inebriation = 0.0;
        efficiency = .85;
        workRate = 50;
    }

    public double writeCode() {
        double currentWorkRate = workRate*(efficiency);
        drinkUp();
        return currentWorkRate;
    }

    public void drinkUp() {
        if (inebriation < 1)
            inebriation += beverage.getABV();
        else
            inebriation = 1;
        efficiency -= .6*inebriation;
    }

    public double getInebriation() {
        return inebriation;
    }

    public double getEfficiencyLevel() {
        return efficiency;
    }

    public String getName() {
        return name;
    }

    public void setBeverage(Kingfisher beverage) {
        this.beverage = beverage;
    }

    public Beverage getBeverage() {
        return beverage;
    }
}
