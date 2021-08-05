package com.lupuleasa.coffee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "Id")
    private Recipe recipe;

    @ManyToOne
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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

    @ManyToMany(mappedBy = "coffees")
    private List<Purchase> purchases;

    private String imagePath;

    private int price;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", recipe=" + recipe +
                ", customer=" + customer +
                ", purchases=" + purchases +
                ", imagePath='" + imagePath + '\'' +
                ", price=" + price +
                '}';
    }
}
