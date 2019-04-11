package com.github.maciejpalczak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Accountant accountant1 = new Accountant((long) 10000, "FirstOneEver");
        Production production1 = new Production(accountant1);
        Client client1 = new Client((long) 3000, "FirstOneEverClient");
        production1.produce();
        System.out.println(accountant1.getBudget());
        production1.produce();
        production1.produce();
        for (Gravel gravel : accountant1.getGravels()) {
            System.out.println(gravel.getWidth() + " " + gravel.getWeight());
        }
        System.out.println(accountant1.getBudget());

        client1.order(0.05, 200.0, (long) 1, accountant1);
        System.out.println(client1.getBudget());
        System.out.println(accountant1.getBudget());
        for (Gravel gravel : accountant1.getGravels()) {
            System.out.println(gravel.getWidth() + " " + gravel.getWeight());
        }
        System.out.println(accountant1.getBudget());

    }
}
