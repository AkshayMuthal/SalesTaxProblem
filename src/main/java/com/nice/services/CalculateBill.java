package com.nice.services;

import com.nice.modules.Cart;
import com.nice.modules.Item;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CalculateBill {
    private static final float ROUNDOFF = 0.05f;
    private List<String> nonTaxableItems;
    private static final Float impportedSalesTax = new Float(0.05);
    private static final Float basicTax = new Float(0.1);

    public CalculateBill(){
        nonTaxableItems = new ArrayList<String>(){
            {
                add("book");
                add("chocolate bar");
                add("box of chocolates");
                add("packet of headache pills");
            }
        };
    }

    private Float  roundOff(Float value){
        value = noInDecimal(value);
        double val = Math.ceil(value / ROUNDOFF) * ROUNDOFF;
        return (float)val;
    }

    private Float noInDecimal(Float value){
        DecimalFormat df = new DecimalFormat("#.00");
        return Float.parseFloat(df.format(value));
    }

    private boolean checkNonTaxbleItem(String name){
        for (String s: this.nonTaxableItems ){
            if(s.contains(name))
                return true;
        }
        return false;
    }

    private Float getTax(Item item){
        Float tax = new Float(0);

        if(item.getImported() && !checkNonTaxbleItem(item.getItemName()))
            tax = item.getItemPrice() * (this.impportedSalesTax + this.basicTax);
        else if(!checkNonTaxbleItem(item.getItemName()))
            tax = item.getItemPrice() * this.basicTax;
        else if(item.getImported())
            tax = item.getItemPrice()*this.impportedSalesTax;

        return tax;
    }

    public void calculateBill(Cart cart){
        for(Item item : cart.getCart()){
            Float tax = getTax(item);

            item.setTotalTax(  item.getCount() * noInDecimal(roundOff(tax)));
            item.setFinalValue(item.getCount() * noInDecimal(item.getItemPrice() + roundOff(tax)));
        }
        cart.setCart(cart.getCart());
    }
}
