package com.nice.modules;

public class Item {
    String itemName;
    Integer count;
    Float itemPrice;
    Boolean isImported;
    Float totalTax;
    Float finalValue;

    public Boolean getImported() {
        return isImported;
    }

    public void setImported(Boolean imported) {
        isImported = imported;
    }

    public Float getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Float totalTax) {
        this.totalTax = totalTax;
    }

    public Float getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(Float finalValue) {
        this.finalValue = finalValue;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Item(Integer count, String name, Float price, Boolean imported){
        this.count = count;
        this.itemName = name;
        this.itemPrice = price;
        this.isImported = imported;
        this.totalTax = new Float(0.0);
        this.finalValue = new Float(0.0);
    }

}
