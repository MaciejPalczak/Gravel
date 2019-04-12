package com.github.maciejpalczak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    public static void runApp() {

        System.out.println("Welcome to the Gravel! \nEnter your name: ");
        String name = scanner.nextLine();
        System.out.println("With what amount of money would you like to start?");

        Long budget = scanner.nextLong();
        Accountant user = new Accountant(budget, name);
        Production usersProduction = new Production(user);
        logger.info("User created his account in CLI");
        choiceSelection(user, usersProduction);

        String choice = "0";
        scanner.nextLine();
        while ((Integer.valueOf(choice) == 4) == false) {
            System.out.println("\nChoose what do you want to do: \n1. Produce random gravel(100 currency cost)\n2. Serve next customer\n3. View your currencies and gravel\n4. Quit app\nEnter your choice: ");
            choice = scanner.nextLine();
            if ((Integer.valueOf(choice) == 1)) {
                usersProduction.produce();
                logger.info("User producted some gravel");
                System.out.println("Your last production was " + user.getGravels().get(user.getGravels().size() - 1).getWeight() + " kilograms of " + user.getGravels().get(user.getGravels().size() - 1).getWidth() + " mm gravel");
            } else if ((Integer.valueOf(choice) == 2)) {
                System.out.println("What's your client name?");
                String clientName = scanner.nextLine();
                System.out.println("What's his budgget?");
                Long budgetClient = scanner.nextLong();
                System.out.println("What minimum size of gravel does he want?");
                Double minClient = scanner.nextDouble();
                System.out.println("What maximum size of gravel does he want?");
                Double maxClient = scanner.nextDouble();
                System.out.println("How many kilograms does he want?");
                Long weightClient = scanner.nextLong();
                Client client = new Client(budgetClient, clientName);
                client.order(minClient, maxClient, weightClient, user);
                logger.info("Choice number 2 completed");
            } else if ((Integer.valueOf(choice) == 3)) {
                System.out.println("You currently have " + user.getBudget() + " money,\nYour gravels: ");
                for (Gravel grvl : user.getGravels()) {
                    System.out.println("Width: " + grvl.getWidth() + "mm, Weight: " + grvl.getWeight() + "kg \n");
                }
            } else if ((Integer.valueOf(choice) == 4)) {
                break;
            } else {
                System.out.println("Wrong input given! Try again!");
            }
        }

    }

    public static void choiceSelection(Accountant user, Production usersProduction) {


    }
}
/*Accountant accountant = new Accountant((long) 3000, "White");
        Gravel gravel = new Gravel((long) 5, 2.5);
        Gravel gravel2 = new Gravel((long) 20, 12.5);
        Gravel gravel3 = new Gravel((long) 56, 52.5);
        Gravel gravel4 = new Gravel((long) 1, 142.5);
        Gravel gravel5 = new Gravel((long) 2, 192.5);
        Client client = new Client((long) 2000,"John");
        accountant.add(gravel.getWeight(),gravel.getWidth());
        accountant.add(gravel2.getWeight(),gravel2.getWidth());
        accountant.add(gravel3.getWeight(),gravel3.getWidth());
        accountant.add(gravel4.getWeight(),gravel4.getWidth());
        accountant.add(gravel5.getWeight(),gravel5.getWidth());

        client.order(2.0,3.0, (long) 2,accountant);
        ArrayList<Gravel>newList=new ArrayList<>();
        newList.add(gravel2);
        newList.add(gravel3);
        newList.add(gravel4);
        newList.add(gravel5);
        newList.add(new Gravel((long) 3,2.5));
        for (Gravel g:newList) {
            System.out.println("New List Gravels weight: "+g.getWeight()+" , width: "+g.getWidth() );
        }
        for (Gravel g:accountant.getGravels()) {
            System.out.println("Old List Gravels weight: "+g.getWeight()+" , width: "+g.getWidth() );
        }
        /*Accountant accountant1 = new Accountant((long) 10000, "FirstOneEver");
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
        System.out.println(accountant1.getBudget());*/