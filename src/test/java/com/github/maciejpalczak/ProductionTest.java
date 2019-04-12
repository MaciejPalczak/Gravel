package com.github.maciejpalczak;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class ProductionTest {
    Accountant accountant = new Accountant((long) 3000, "White");
    Production production = new Production(accountant);

    @Test
    public void shouldCheckAccountant() {
        assertTrue(production.getAccountant().equals(accountant));
    }
    @Test
    public void shouldProduceGravel(){
        production.produce();
        assertFalse(accountant.getGravelsWeight()==0);
        assertTrue(accountant.getBudget()==2900);
    }
    @Test
    public void shouldNotProduce(){
        accountant.setBudget((long) 50);
        production.produce();
        assertTrue(accountant.getGravels().isEmpty());
        assertTrue(accountant.getBudget()==50);
    }
}

