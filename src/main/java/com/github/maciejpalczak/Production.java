package com.github.maciejpalczak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Production {

    private static final Logger logger = LoggerFactory.getLogger(Accountant.class);
    private static final Random rand = new Random();
    private Accountant accountant;

    public void produce() {
        if (accountant.getBudget()>=(long)100) {
            Integer value = rand.nextInt(1000); //value of dust in kilograms
            Double width = rand.nextDouble() * 200; //create random width multiplied by 200 to create number between 0 and 200mm
            accountant.add(Long.valueOf(value), width); //accountant of application notifies production of graves
            accountant.setBudget(accountant.getBudget()-100);
        }
        else{
            logger.warn("Accountant doesnt have enough money for more productions");
        }
    }

    public Accountant getAccountant() {
        return accountant;
    }

    public Production(Accountant accountant) {
        this.accountant = accountant; //Production is bounded with one assistant for it, for future implementation you can have a factory with many productions and accountants
        logger.info("Production create succesfully");
    }
}
