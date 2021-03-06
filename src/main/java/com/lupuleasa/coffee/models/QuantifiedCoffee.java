package com.lupuleasa.coffee.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QuantifiedCoffee")
public class QuantifiedCoffee{

    @Id
    private int id;
    private int uid;
    private String name;
    private int amount;
    private float price;
    private String imagePath;

    @ManyToMany(mappedBy = "coffees")
    private List<Purchase> purchases;


    @ManyToMany(mappedBy = "coffees")
    private List<Cart> carts;


    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}