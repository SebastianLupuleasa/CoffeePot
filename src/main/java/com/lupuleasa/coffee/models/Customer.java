package com.lupuleasa.coffee.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique=true)
    private String userName;
    private String password;
    private String roles;

    @OneToMany(mappedBy = "customer")
    private List<Coffee> custom_coffees;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart", referencedColumnName = "id")
    private Cart cart;

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Coffee> getCustom_coffees() {
        return custom_coffees;
    }

    public void setCustom_coffees(List<Coffee> custom_coffees) {
        this.custom_coffees = custom_coffees;
    }

    public List<Purchase> getOrders() {
        return purchases;
    }

    public void setOrders(List<Purchase> orders) {
        this.purchases = purchases;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}

