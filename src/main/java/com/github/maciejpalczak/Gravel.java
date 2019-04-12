package com.github.maciejpalczak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

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

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gravel)) return false;
        Gravel gravel = (Gravel) o;
        return Objects.equals(getWeight(), gravel.getWeight()) &&
                Objects.equals(getWidth(), gravel.getWidth());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getWeight(), getWidth());
    }
}
