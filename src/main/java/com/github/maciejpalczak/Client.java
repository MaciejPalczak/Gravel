package com.github.maciejpalczak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Client {
    private static Long budget;
    private final String name;
    private static final Logger logger = LoggerFactory.getLogger(Client.class);


    public static void order(Double minWidth, Double maxWidth, Long weight, Accountant accountant) {
        if (minWidth > maxWidth) {
            logger.error("Wrong range given");
        }
        else if(weight*100>budget){
            logger.error("Client doesnt have enough money for his order");
        }
        else{
            ArrayList<Gravel>gravels=accountant.getGravels();
            List<Gravel> filteredOne=gravels.stream()
                    .filter(x->x.getWidth()>=minWidth)
                    .filter(x->x.getWidth()<=maxWidth)
                    .collect(toList());
            Long sumMatching= Long.valueOf(0);
            for (Gravel gravel:filteredOne) {
                sumMatching+=gravel.getWeight();
            }
            if (sumMatching<weight){
                logger.error("Not enough resources to make this order");
            }
            else{
                int i=0;
                Long weightt=weight;
                while(weightt>0){
                    weightt= weightt - filteredOne.get(i).getWeight();
                    accountant.getGravels().remove(filteredOne.get(i));
                    if (weightt<0){
                        accountant.add(-1*weightt,filteredOne.get(i).getWidth());
                    }
                    i++;
                }
                accountant.setBudget(accountant.getBudget()+(weight*100)); //cost of 1 kilogram of gravel is equal 100 currency
                setBudget(getBudget()-weight*100);
            }
        }
    }
    public static Long getBudget() {
        return budget;
    }

    public String getName() {
        return name;
    }

    public static void setBudget(Long budget) {
        Client.budget = budget;
    }

    public Client(Long budget, String name) {
        this.name = name;
        this.budget = budget;
        logger.info("Client created succesfully");
    }

}

