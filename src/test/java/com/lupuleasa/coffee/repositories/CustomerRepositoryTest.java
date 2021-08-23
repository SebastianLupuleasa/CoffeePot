package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class CustomerRepositoryTest {

    private String customerName;

    @Autowired
    private CustomerRepository underTest;


    @BeforeEach
    void setUp() {

        customerName="Mark";
        Customer customer = new Customer();
        List<Coffee> coffees= new ArrayList<Coffee>();
        Cart cart = new Cart();
        List<Purchase> purchases = new ArrayList<Purchase>();
        customer.setCart(cart);
        customer.setCustom_coffees(coffees);
        customer.setPurchases(purchases);
        customer.setUserName(customerName);

        underTest.save(customer);
    }

    @Test
    void itShouldFindByName() {

        // given

        // setUp function

        //when
        Customer found = underTest.findByUserName(customerName);


        //then
        assertThat(found).isNotNull();

    }


    @Test
    void itShouldNotFindByName() {

        // given

        // setUp function

        //when
       Customer found = underTest.findByUserName("");


        //then
        assertThat(found).isNull();

    }
}