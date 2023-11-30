package com.techelevator.filereader;

import com.techelevator.items.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

import static com.techelevator.filereader.LogFileWriter.errorLog;

/**
 * This class would be a GREAT place to read in a file and return a data structure matching the one in
 * your Inventory class. (You probably saw something similar in some review code we did....)
 */
public class InventoryFileReader {

    // Hmmm.... looks like a great place to create some form or method called readFile....
    private String filePath;
    Map<String, Item> inventoryMap = new HashMap<>();

    public void setFilePath(String inventoryFilePath) {
        this.filePath = inventoryFilePath;
    }

    public Map<String, Item> setInventory() {
        File inventory = new File(filePath);
        try (Scanner inputScanner = new Scanner(inventory)) {
            while (inputScanner.hasNext()) {
                String currentLineFromFile = inputScanner.nextLine();
                String[] currentLineArray = currentLineFromFile.split("\\|");
                inventoryMap.put(currentLineArray[1], new Item(currentLineArray));
            }
        } catch (FileNotFoundException e) {
            errorLog(e.getMessage());
        }
        return inventoryMap;
    }

    public void displayInventory(){
        String header = String.format("%-10s  %-15s  %-5s  %-10s  %-5s", "Id", "Name", "Wrapper","Quantity","Price");
        System.out.println(header);
        List<String> alist = new ArrayList<>(this.inventoryMap.keySet());
        Collections.sort(alist);
        for ( String each : alist){
            Item name = this.inventoryMap.get(each);
            String invItem = String.format("%-10s  %-15s  %-7s  %-10s  $%.2f",
                    name.getItemID(),
                    name.getName(),
                    name.isHasWrapper(),
                    name.getQuantity() == 0? "SOLD OUT": name.getQuantity(),
                    name.getPrice());
            System.out.println(invItem);
        }

    }

    @Override
    public String toString() {
        return "InventoryFileReader{" +
                "filePath='" + filePath + '\'' +
                ", inventoryMap=" + inventoryMap +
                '}';
    }

    public Map<String, Item> getInventoryMap() {
        return inventoryMap;
    }
}
