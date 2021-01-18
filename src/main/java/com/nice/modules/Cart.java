package com.nice.modules;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Item> cart= new ArrayList<Item>();

    public void addItem(Item item){
        this.cart.add(item);
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void printCart(){
        Float salesTax = new Float(0);
        Float totalBill = new Float(0);
        for(Item item: this.cart){
            salesTax += item.getTotalTax();
            totalBill += item.getFinalValue();
            String output = "";
            output += item.getCount();
            output = (item.getImported()) ? output += " imported " : output;
            System.out.println(output+" "
                            +item.getItemName()+": "
                            +item.getFinalValue());
        }
        System.out.println("Sales Taxes: "+salesTax);
        System.out.printf("Total: %.2f\n",totalBill);
    }
}
