package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Coffee;
import com.lupuleasa.coffee.models.Customer;
import com.lupuleasa.coffee.models.QuantifiedCoffee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class QuantifiedCoffeeRepositoryTest {

    private String coffeeName;

    @Autowired
    private QuantifiedCoffeeRepository underTest;

    @Autowired
    private CustomerRepository customerRepo;

    private Customer customer;

    private  QuantifiedCoffee qcoffee;

    @BeforeEach
    void setUp() {

        qcoffee = new QuantifiedCoffee();
        coffeeName="coffeeTest";

        qcoffee.setName(coffeeName);

        customer = new Customer();
        customer.setUserName("Jan");
        customerRepo.save(customer);

        qcoffee.setUid(customerRepo.findByUserName("Jan").getId());

        underTest.save(qcoffee);
    }

    @Test
    void itShouldGetByName() {


        // given

        // setup function

        // when
        QuantifiedCoffee found = underTest.getByname(coffeeName);

        // then
        assertThat(found).isNotNull();

    }

    @Test
    void itShouldNotGetByName() {


        // given

        // setup function

        // when
        QuantifiedCoffee found = underTest.getByname("");

        // then
        assertThat(found).isNull();

    }

    @Test
    void itShouldFindByCustomerId() {

        // given

        // setup function

        // when
        List<QuantifiedCoffee> found = underTest.findByCustomerId(qcoffee.getUid());

        // then
        assertThat(found).isNotEmpty();
    }

    @Test
    void itShouldNotFindByCustomerId() {

        // given

        // setup function

        // when
        List<QuantifiedCoffee> found = underTest.findByCustomerId(-99);

        // then
        assertThat(found).isEmpty();
    }


    @Test
    void itShouldExistsByName() {

        // given

        // setup function

        // when
       Boolean found = underTest.existsByName(coffeeName);

        // then
        assertThat(found).isTrue();

    }

    @Test
    void itShouldNotExistsByName() {

        // given

        // setup function

        // when
        Boolean found = underTest.existsByName("");

        // then
        assertThat(found).isFalse();

    }

    @Test
    void itShouldGetQuantifiedCoffeeByNameAndUid() {

        // given

        // setup function

        // when
       QuantifiedCoffee found = underTest.getQuantifiedCoffeeByNameAndUid(coffeeName, qcoffee.getUid());

        // then
        assertThat(found).isNotNull();

    }

    @Test
    void itShouldNotGetQuantifiedCoffeeByNameAndUid() {

        // given

        // setup function

        // when
        QuantifiedCoffee found = underTest.getQuantifiedCoffeeByNameAndUid("", -99);

        // then
        assertThat(found).isNull();

    }
}