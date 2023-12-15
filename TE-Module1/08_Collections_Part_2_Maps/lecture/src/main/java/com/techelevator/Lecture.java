package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Lecture {

       public static void main(String[] args){
           System.out.println("Welcome to Java Blue");
           Scanner scanner = new Scanner(System.in);
           Map<String, String> jbMorningBrew = new HashMap<>();
           String stop = "";
           while(stop.length()==0) {
               System.out.println("Please enter a name or x to end the program: ");
               //capture user input (make a scanner)

               String username = scanner.nextLine();
               //printing feedback and prompting user
               if (username.equalsIgnoreCase("X")) {
                   stop = username;
               } else {
                   System.out.println("Please enter your preferred morning beverage:");
                   //capture favor bev
                   String beverage = scanner.nextLine();

                   jbMorningBrew.put(username, beverage);

               }
           }
           System.out.println(jbMorningBrew);
            int countCoffeeDrinkers = 0;
           for(Map.Entry<String, String> currentEntry : jbMorningBrew.entrySet()){
               if (currentEntry.getValue().equalsIgnoreCase("coffee")){
                   countCoffeeDrinkers++;
               }
           }
           System.out.println("There are " + countCoffeeDrinkers + " coffee drinkersin jbMorningBrew");

    }
}
