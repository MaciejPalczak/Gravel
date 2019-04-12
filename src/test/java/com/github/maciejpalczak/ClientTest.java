package com.github.maciejpalczak;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

@Ignore
public class ClientTest {

    Accountant accountant = new Accountant((long) 3000, "White");
    Gravel gravel = new Gravel((long) 5, 2.5);
    Gravel gravel2 = new Gravel((long) 20, 12.5);
    Gravel gravel3 = new Gravel((long) 56, 52.5);
    Gravel gravel4 = new Gravel((long) 1, 142.5);
    Gravel gravel5 = new Gravel((long) 2, 192.5);
    Client client = new Client((long) 2000,"John");
    @Before
    public void fillAccountant(){
        accountant.add(gravel.getWeight(),gravel.getWidth());
        accountant.add(gravel2.getWeight(),gravel2.getWidth());
        accountant.add(gravel3.getWeight(),gravel3.getWidth());
        accountant.add(gravel4.getWeight(),gravel4.getWidth());
        accountant.add(gravel5.getWeight(),gravel5.getWidth());
    }

    @Test
    public void shouldCheckName() {
        assertTrue(client.getName().equals("John"));
    }

    @Test
    public void shouldCheckBudget() {
        assertTrue(client.getBudget()==2000);
    }

    @Test
    public void shouldNotOrderDueToWrongRange(){
        client.order(200.0,1.0, (long) 2000,accountant);
        assertTrue(client.getBudget()==2000&&accountant.getBudget()==3000);
    }

    @Test
    public void shouldNotOrderDueToNotEnoughMoney(){
        client.order(1.0,200.0, (long) 2000,accountant);
        assertTrue(client.getBudget()==2000&&accountant.getBudget()==3000);
    }

    @Test
    public void shouldNotOrderDueToNotEnoughGravel(){
        client.order(199.0,200.0, (long) 15,accountant);
        assertTrue(client.getBudget()==2000&&accountant.getBudget()==3000);
    }

    @Test
    public void shouldCheckAccountantAndClientBudget(){
        client.order(1.0,200.0, (long) 10,accountant);
        assertTrue(client.getBudget()==1000&&accountant.getBudget()==4000);
    }

    @Test
    public void shouldCheckAccountantMaterialsAfterOrder1(){
        client.order(2.0,3.0, (long) 2,accountant);
        ArrayList<Gravel>newList=accountant.getGravels();
        newList.remove(gravel);
        newList.add(new Gravel((long) 3,2.5));
        assertTrue(newList.equals(accountant.getGravels()));
    }

    @Test
    public void shouldCheckAccountantMaterialsAfterOrder2(){
        ArrayList<Gravel>newList=accountant.getGravels();
        client.order(135.0,145.0, (long) 1,accountant);
        newList.remove(gravel4);
        assertTrue(newList.equals(accountant.getGravels()));
    }
    @Test
    public void shouldCheckAccountantMaterialsAfterOrder3(){
        ArrayList<Gravel>newList=accountant.getGravels();
        client.order(2.0,13.0, (long) 10,accountant);
        newList.remove(gravel);
        newList.remove(gravel2);
        newList.add(new Gravel((long) 15,12.5));
        assertTrue(newList.equals(accountant.getGravels()));
    }
}
