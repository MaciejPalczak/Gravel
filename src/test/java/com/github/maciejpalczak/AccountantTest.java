package com.github.maciejpalczak;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class AccountantTest {

    Accountant accountant = new Accountant((long) 3000, "White");
    Production production = new Production(accountant);
    Gravel gravel = new Gravel((long) 5, 2.5);


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
    @Test
    public void shouldAddSingleGravel(){
        accountant.add(gravel.getWeight(), gravel.getWidth());
        assertFalse(accountant.getGravels().isEmpty());
    }
    @Test
    public void shouldReturnGravelsWeight(){
        accountant.add(gravel.getWeight(), gravel.getWidth());
        assertTrue(accountant.getGravelsWeight()==5);
    }
    @Test
    public void shouldCheckId() {
        assertTrue(accountant.getId().equals("White"));
    }

    @Test
    public void shouldCheckBudget() {
        assertTrue(accountant.getBudget().equals(3000));
    }
}
