package com.nice.services;

import com.nice.modules.Item;

public class GetItems {
    private String getItemName(String line){
        String[] token = line.split(" ");
        int i=1;
        String itemName = "";
        while (!token[i].equals("at")){
            if(!token[i].contains("imported"))
                itemName = (itemName.equals("")) ? token[i] : itemName + " " + token[i];
            i++;
        }
        return itemName;
    }

    public Item getItem(String line){
        String[] token = line.split(" ");

        Integer count = Integer.parseInt(String.valueOf(token[0]));
        Float itemPrice = Float.parseFloat(String.valueOf(token[token.length-1]));

        Boolean isImported = false;
        String itemName = getItemName(line);

        if(line.contains("imported"))
            isImported = true;
        return new Item(count, itemName, itemPrice, isImported);
    }
}
