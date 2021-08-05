package com.lupuleasa.coffee;

import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String userName;
    private String password;
    private String roles;

    @OneToMany(mappedBy = "customer")
    private List<Coffee> custom_coffees;

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "Id")
    private Address address;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", custom_coffees=" + custom_coffees +
                ", purchases=" + purchases +
                ", address=" + address +
                '}';
    }
}

