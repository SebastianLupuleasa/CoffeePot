package com.lupuleasa.coffee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float total;

    @ManyToMany()
    private List<QuantifiedCoffee> coffees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<QuantifiedCoffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<QuantifiedCoffee> coffees) {
        this.coffees = coffees;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
