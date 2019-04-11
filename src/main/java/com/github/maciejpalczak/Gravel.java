package com.github.maciejpalczak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gravel {

    private Long weight; //weight in kilograms
    private Double width; //width in milimeters
    private static final Logger logger = LoggerFactory.getLogger(Gravel.class);

    public Long getWeight() {
        return weight;
    }

    public Double getWidth() {
        return width;
    }

    public Gravel(Long weight, Double width) {
        this.weight = weight;
        this.width = width;
        logger.info("Gravel created succesfully");
    }
}
