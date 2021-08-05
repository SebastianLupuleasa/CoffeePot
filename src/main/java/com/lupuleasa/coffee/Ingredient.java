package com.lupuleasa.coffee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    private int price;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recipes;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", recipes=" + recipes +
                '}';
    }
}
