package com.github.maciejpalczak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Accountant {

    private static final Logger logger = LoggerFactory.getLogger(Accountant.class);
    private String id;
    private Long budget;
    private static ArrayList<Gravel> gravels = new ArrayList<>();
    public static void add(Long value, Double width) {
        gravels.add(new Gravel(value,width));
    }

    public static Long getGravelsWeight() {
        Long value = Long.valueOf(0);
        for (Gravel gravel : gravels) {
            value += gravel.getWeight();
        }
        return value;
    } // returns sum of all dust in kilograms

    public static ArrayList<Gravel> getGravels() {
        return gravels;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Accountant(Long budget, String id) {
        this.budget = budget;
        this.id=id;
        logger.info("Accountant created succesfully");
    }

    public String getId() {
        return id;
    }
}