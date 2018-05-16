package com.example.fadi.supermarket.model;

public class Offer {

    private String itemList;
    private double price;

    public Offer() {

    }

    public Offer(String itemList, double price) {
        this.itemList = itemList;
        this.price = price;
    }

    public String getItemList() {
        return itemList;
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "itemList='" + itemList + '\'' +
                ", price=" + price +
                '}';
    }
}
