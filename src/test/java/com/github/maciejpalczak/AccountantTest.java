package com.github.maciejpalczak;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class AccountantTest {

    Accountant accountant = new Accountant((long) 3000, "White");
    Accountant accountant2 = new Accountant((long) 50, "Black");
    Accountant accountant3 = new Accountant((long) 2500, "Grey");
    Production production = new Production(accountant);
    Production production2 = new Production(accountant2);
    Gravel gravel = new Gravel((long) 5, 2.5);


    @Test
    public void shouldCheckAccountant() {
        assertTrue(production.getAccountant().equals(accountant));
    }

    @Test
    public void shouldReturnGravelsWeight(){
        accountant3.add(gravel.getWeight(), gravel.getWidth());
        assertTrue(accountant3.getGravelsWeight()==5);
    }

    @Test
    public void shouldProduceGravel(){
        production.produce();
        assertFalse(accountant.getGravelsWeight()==0);
        assertTrue(accountant.getBudget()==2900);
    }

    @Test
    public void shouldAddSingleGravel(){
        accountant.add(gravel.getWeight(), gravel.getWidth());
        assertFalse(accountant.getGravels().isEmpty());
    }

    @Test
    public void shouldCheckId() {
        assertTrue(accountant.getId().equals("White"));
    }

    @Test
    public void shouldCheckBudget() {
        assertTrue(accountant.getBudget()==(3000));
    }

    @Test
    public void shouldNotProduce(){
        production2.produce();
        assertTrue(accountant2.getGravels().isEmpty());
        assertTrue(accountant2.getBudget()==50);
    }
}
