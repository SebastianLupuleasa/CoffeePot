package com.lupuleasa.coffee.models;

import com.lupuleasa.coffee.models.Customer;
import com.lupuleasa.coffee.models.QuantifiedCoffee;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<QuantifiedCoffee> coffees;

    private float amount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_date")
    private Date createDate;

    private String deliver;

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<QuantifiedCoffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<QuantifiedCoffee> coffees) {
        this.coffees = coffees;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
