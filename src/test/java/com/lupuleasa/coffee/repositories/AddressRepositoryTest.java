package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import java.util.Optional;

@DataJpaTest
class AddressRepositoryTest {

    private String streetName;

    @Autowired
    private AddressRepository underTest;


    @BeforeEach
    void setUp() {

           streetName="Strada Test";
        Address address = new Address();
        address.setStreetName(streetName);
        address.setBuildingNumber(22);

        underTest.save(address);
    }


    @Test
    void itShouldFindByStreetName() {

        // given

        // setUp function

        //when
        Optional<Address> found = underTest.findByStreetName(streetName);


        //then
        assertThat(found).isNotEmpty();

    }


    @Test
    void itShouldNotFindByStreetName() {

        // given

        // setUp function

        //when
       Optional<Address> found = underTest.findByStreetName("");


        //then
        assertThat(found).isEmpty();

    }
}