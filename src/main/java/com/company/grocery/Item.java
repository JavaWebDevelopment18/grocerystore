package com.company.grocery;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Item {


    @NotNull
    private double price;

    @NotNull
    private int quantity;

    @NotNull
    @Size(min = 5)
    private String name;

    public Item(){
    }

    public Item(double p, int q, String n){
        this.price = p;
        this.quantity = q;
        this.name = n;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
