package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lecture {


    public static void main(String[] args) {
        //greet user
        System.out.println("Welcome to Java Blue");
        Scanner scanner = new Scanner(System.in);
        Map<String,String> jbMorningBrew = new HashMap<String, String>();

        String stop = "";
        while(stop.length()==0){
            System.out.println("Please enter a name or enter x to end program");
            //capture user input only need one scanner and will reuse scanner object

            String username = scanner.nextLine();
            //printing feedback and prompting the user
            if(username.equalsIgnoreCase("x")){
                stop = username;
            } else{
                System.out.println("Please enter the preferred morning beverage:");
                //capture users favorite morning beverage
                String beverage = scanner.nextLine();

                jbMorningBrew.put(username, beverage);
            }

        }

        System.out.println(jbMorningBrew);
        int countCoffeeDrinkers = 0;

        for(Map.Entry<String,String> currentEntry : jbMorningBrew.entrySet()){
            if(currentEntry.getValue().equalsIgnoreCase("coffee")){
                countCoffeeDrinkers++;
            }
        }

        System.out.println("There are " + countCoffeeDrinkers + " in jbMorningBrew");

    }
}
