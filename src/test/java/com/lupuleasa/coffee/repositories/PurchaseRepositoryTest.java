package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Coffee;
import com.lupuleasa.coffee.models.Customer;
import com.lupuleasa.coffee.models.Purchase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.parameters.P;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class PurchaseRepositoryTest {


    private Customer customer;

    @Autowired
    private PurchaseRepository underTest;

    @Autowired
    private CustomerRepository customerRepo;


    @BeforeEach
    void setUp() {

        underTest.deleteAll();
        customer = new Customer();
        customerRepo.save(customer);

        Purchase p = new Purchase();
        p.setCustomer(customer);

        underTest.save(p);
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindByCustomer() {


        // given

        // setup function

        // when
        List<Purchase> found = underTest.findByCustomer(customer);

        // then
        assertThat(found).isNotEmpty();

    }

    @Test
    void itShouldNotFindByCustomer() {


        // given

        // setup function

        // when
        List<Purchase> found = underTest.findByCustomer(null);

        // then
        assertThat(found).isEmpty();

    }
}