package com.techelevator.SadSallyPizzaShop;

import java.util.Scanner;
public class PizzaShop {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Constants for menu item codes
            final int SMALL_CHEESE = 10;
            final int SMALL_PEPPERONI = 11;
            final int MEDIUM_CHEESE = 20;
            final int MEDIUM_PEPPERONI = 21;
            final int LARGE_CHEESE = 30;
            final int LARGE_PEPPERONI = 31;
            final int CALZONE = 40;
            final int SPAGHETTI_PIE = 41;
            final int BAKED_ZITI = 42;

            // Create an initial order
            int[] order = {SMALL_CHEESE, CALZONE, LARGE_PEPPERONI, SPAGHETTI_PIE};

            // Display the initial order
            System.out.println("Initial Order:");
            for (int itemCode : order) {
                if (itemCode == 10) {
                    System.out.println("Small Cheese Pizza - $8.00");
                } else if (itemCode == 11) {
                    System.out.println("Small Pepperoni Pizza");
                } else if (itemCode == 20) {
                    System.out.println("Medium Cheese Pizza - $11.00");
                } else if (itemCode == 21) {
                    System.out.println("Medium Pepperoni Pizza");
                } else if (itemCode == 30) {
                    System.out.println("Large Cheese Pizza - $14.00");
                } else if (itemCode == 31) {
                    System.out.println("Large Pepperoni Pizza");
                } else if (itemCode == 40) {
                    System.out.println("Calzone");
                } else if (itemCode == 41) {
                    System.out.println("Spaghetti Pie");
                } else if (itemCode == 42) {
                    System.out.println("Baked Ziti");
                } else {
                    System.out.println("Invalid item code");
                }
            }

            // Prompt the user for additional items
            while (true) {
                System.out.print("Enter the item code to add to the order (or 0 to finish): ");
                int itemCode = Integer.parseInt(scanner.nextLine());
                if (itemCode == 0) {
                    break; // Finish ordering
                }

                boolean isValidCode = false;
                if (itemCode == SMALL_CHEESE || itemCode == SMALL_PEPPERONI || itemCode == MEDIUM_CHEESE ||
                        itemCode == MEDIUM_PEPPERONI || itemCode == LARGE_CHEESE || itemCode == LARGE_PEPPERONI ||
                        itemCode == CALZONE || itemCode == SPAGHETTI_PIE || itemCode == BAKED_ZITI) {
                    isValidCode = true;
                }

                if (isValidCode) {
                    int[] newOrder = new int[order.length + 1];
                    for(int i = 0; i < order.length; i++) {
                        newOrder[i] = order[i];
                    }
                    newOrder[order.length] = itemCode;
                    order = newOrder;

                    System.out.println("Updated Order:");
                    for (int code : order) {
                        if (code == 10) {
                            System.out.println("Small Cheese Pizza - $8.00");
                        } else if (code == 11) {
                            System.out.println("Small Pepperoni Pizza");
                        } else if (code == 20) {
                            System.out.println("Medium Cheese Pizza - $11.00");
                        } else if (code == 21) {
                            System.out.println("Medium Pepperoni Pizza");
                        } else if (code == 30) {
                            System.out.println("Large Cheese Pizza - $14.00");
                        } else if (code == 31) {
                            System.out.println("Large Pepperoni Pizza");
                        } else if (code == 40) {
                            System.out.println("Calzone");
                        } else if (code == 41) {
                            System.out.println("Spaghetti Pie");
                        } else if (code == 42) {
                            System.out.println("Baked Ziti");
                        } else {
                            System.out.println("Invalid item code");
                        }
                    }
                } else {
                    System.out.println("Invalid item code. Please enter a valid item code.");
                }
            }

            int totalRevenueOfCheesePizzas = 0;
            for (int itemCode : order) {
                if (itemCode == 10) {
                    totalRevenueOfCheesePizzas += 8;
                } else if (itemCode == 20) {
                    totalRevenueOfCheesePizzas += 11;
                } else if (itemCode == 30) {
                    totalRevenueOfCheesePizzas += 14;
                }
            }

            System.out.println("Final Order:");
            for (int code : order) {
                if (code == 10) {
                    System.out.println("Small Cheese Pizza - $8.00");
                } else if (code == 11) {
                    System.out.println("Small Pepperoni Pizza");
                } else if (code == 20) {
                    System.out.println("Medium Cheese Pizza - $11.00");
                } else if (code == 21) {
                    System.out.println("Medium Pepperoni Pizza");
                } else if (code == 30) {
                    System.out.println("Large Cheese Pizza - $14.00");
                } else if (code == 31) {
                    System.out.println("Large Pepperoni Pizza");
                } else if (code == 40) {
                    System.out.println("Calzone");
                } else if (code == 41) {
                    System.out.println("Spaghetti Pie");
                } else if (code == 42) {
                    System.out.println("Baked Ziti");
                } else {
                    System.out.println("Invalid item code");
                }
            }

            System.out.println("Total Revenue for Cheese Pizzas: $" + totalRevenueOfCheesePizzas);


        }


}
