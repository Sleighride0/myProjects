package com.techelevator.items.filereader;

import com.techelevator.items.Apparel;
import com.techelevator.items.Food;
import com.techelevator.items.HomeGood;
import com.techelevator.items.Item;
import com.techelevator.logger.Logger;


import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class InventoryBuilder {

    private final String filePath;

    public InventoryBuilder(String inventoryFilePath){
        this.filePath = inventoryFilePath;
    }



    public Map<String, Item> getInventory(){
        Map<String, Item> inventoryMap = new HashMap<>();
        //use the string filePath to make an instance of a File
        File inventoryFile = new File(filePath);
        //build a Scanner object and use the File as a source
        try(Scanner inventoryScanner = new Scanner(inventoryFile)){
            //look at each line in the file using the scanner
            while(inventoryScanner.hasNext()){
                //make new items
                //based off of the current line from the file
              String currentLineFromFile = inventoryScanner.nextLine();
                //determine if you should build a Food, Apparel or HomeGood and put the item in the map
               String[] currentLineArray =  currentLineFromFile.split("\\|");
               String sku = currentLineArray[0];
               String name = currentLineArray[1];
               String description = currentLineArray[2];
               String price = currentLineArray[3];
               String dept = currentLineArray[4];

               Item item = null;

               if(dept.equals("A")){
                   item = new Apparel(sku);

               } else if(dept.equals("HG")){
                   item =  new HomeGood(sku);

               } else if(dept.equals("F")){
                   item = new Food(sku,false);

               } else {
                   item = new Food(sku,true);

               }

                item.setName(name);
                item.setDescription(description);
                item.setPrice(new BigDecimal(price));
                inventoryMap.put(sku, item);
            }

        } catch (FileNotFoundException e) {
            Logger logger = new Logger("log.txt");
            logger.write(e.getMessage());
        }


        return inventoryMap;
    }
}
