package com.techelevator.items.filereader;

import com.techelevator.items.Apparel;
import com.techelevator.items.Food;
import com.techelevator.items.HomeGood;
import com.techelevator.items.Item;
import com.techelevator.logger.Logger;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class InventoryBuilder {

    private final String filePath;

    public InventoryBuilder(String inventoryFilePath) {
        this.filePath = inventoryFilePath;
    }

    public Map<String, Item> getInventory() {
        Map<String, Item> inventoryMap = new HashMap<>();
        File inventory = new File(filePath);
        try (Scanner inputScanner = new Scanner(inventory)) {
            while (inputScanner.hasNext()) {
                //make new items
                String currentLineFromFile = inputScanner.nextLine();
                String[] currentLineArray = currentLineFromFile.split("\\|");
                String sku = currentLineArray[0];
                String name = currentLineArray[1];
                String description = currentLineArray[2];
                String price = currentLineArray[3];
                String dept = currentLineArray[4];

                Item item = null;

                if (dept.equals("A")) {
                    item = new Apparel(sku);
                } else if (dept.equals("HG")) {
                    item = new HomeGood(sku);
                } else if (dept.equals("F")) {
                    item = new Food(sku, false);
                } else {
                    item = new Food(sku, true);
                }
                item.setName(name);
                item.setDescription(description);
                item.setPrice(new BigDecimal(price));
                inventoryMap.put(sku, item);
                System.out.println(currentLineArray[0]);
            }
        } catch (FileNotFoundException e) {
            Logger logger = new Logger("log.txt");
            logger.write(e.getMessage());
        }

        return inventoryMap;


    }

}
