package com.nice.containers;

import com.nice.modules.Cart;
import com.nice.modules.Item;
import com.nice.services.CalculateBill;
import com.nice.services.GetItems;

import java.io.InputStream;
import java.util.Scanner;

public class SaleProblem {

    private void readFile(){
        String line;
        GetItems getItems = new GetItems();
        CalculateBill calculateBill = new CalculateBill();

        try{
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("input.txt");
            Scanner sc = new Scanner(inputStream);
            while (sc.hasNextLine()){
                line = sc.nextLine();
                Cart cart = new Cart();

                while (!line.contains("Input") && !line.equals("")){
                    Item item = getItems.getItem(line);
                    cart.addItem(item);
                    if (!sc.hasNextLine())
                        break;
                    line = sc.nextLine();
                }
                if(!cart.getCart().isEmpty()){
                    calculateBill.calculateBill(cart);
                    cart.printCart();
                }
            }
            sc.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        SaleProblem saleProblem = new SaleProblem();
        saleProblem.readFile();
    }
}
