package com.techelevator;

import com.techelevator.items.Item;
import com.techelevator.items.filereader.InventoryBuilder;
import com.techelevator.view.Menu;
import java.util.List;

import java.util.Map;

public class BlueStoreApp {

    /* To ensure that we only load the inventory once, we are setting the inventory map when we create OrangeStoreApp in main()*/
    private Menu menu = new Menu();
    private Map<String, Item> inventory;

    public BlueStoreApp(Map<String,Item> inventory){
        this.inventory = inventory;
    }
    public void run() {
        menu.displayHomeScreen();

        while(true) {

            String choice = menu.getHomeScreenOption();
           // menu.displayMessage(choice);
            if(choice.equals("display")) {
                // display the items
                menu.displayInventory(inventory);
            }
            else if(choice.equals("purchase")) {
                //note that the menu's getUserCartSelection() method includes a while loop to keep displaying purchasing options
                //once the user enters 'done' then the loop breaks
               List<String> skusInCart = menu.getUserCartSelections(choice);
               menu.displayMessage("You selected:");
               for(String sku : skusInCart){
                   menu.displayMessage(String.valueOf(inventory.get(sku)));
               }

            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }
    /* The main entry point for the application */
    public static void main(String[] args) {
        InventoryBuilder inventoryBuilder = new InventoryBuilder("inventory.csv");
        BlueStoreApp javaBlueApp = new BlueStoreApp(inventoryBuilder.getInventory());
        javaBlueApp.run();
    }
}
