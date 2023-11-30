package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart extends InventoryFileReader{
    private double total;
    private int quantityInCart;
    List<Item> shoppingCart = new ArrayList<>();

    Map<String, Integer> cartMap;


    public double getTotal() {
        double sum = 0;
        for (Item each : shoppingCart) {
            sum += each.getPrice();
        } return sum;
    }
    public Map<String, Integer> cartCount(){
        cartMap = new HashMap<>();
        for(Item each : shoppingCart){
            if (!cartMap.containsKey(each.getItemID())) {
                cartMap.put(each.getItemID(), 1);
            } else {
                cartMap.put(each.getItemID(),cartMap.get(each.getItemID()) + 1);
            }
        }
        return cartMap;
    }


    public void currentCart(Map<String, Item> dict){
        cartCount();
        for( Map.Entry<String, Integer>  each: cartMap.entrySet()){
            String invItem = String.format("%-10s  %-15s  %-20s  %-7s  $%.2f",
                    each.getValue(),
                    dict.get(each.getKey()).getName(),
                    dict.get(each.getKey()).getDesc(),
                    dict.get(each.getKey()).getPrice(),
                    each.getValue() * dict.get(each.getKey()).getPrice());
            System.out.println(invItem);
        }
        System.out.println("");
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantityInCart() {
        return quantityInCart;
    }

    public void setQuantityInCart(int quantityInCart) {
        this.quantityInCart = quantityInCart;
    }

    public List<Item> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<Item> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
