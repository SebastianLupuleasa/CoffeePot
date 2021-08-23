package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Coffee;
import com.lupuleasa.coffee.models.Customer;
import com.lupuleasa.coffee.models.Recipe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class CoffeeRepositoryTest {

    @Autowired
    private CoffeeRepository underTest;

    @Autowired
    private RecipeRepository recipeRepo;

    @Autowired
    private CustomerRepository customerRepo;


    private String name;
    private int id;
    private Recipe recipe;
    private Customer customer;
    private Coffee testCoffee;

    @BeforeEach
    void setUp() {

        underTest.deleteAll();
        recipe = new Recipe();
        recipeRepo.save(recipe);

        customer = new Customer();
        customerRepo.save(customer);

        testCoffee = new Coffee();

        name= "Test Coffee";
        testCoffee.setName(name);
        testCoffee.setCustomer(customer);
        testCoffee.setRecipe(recipe);

        underTest.save(testCoffee);

    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldGetByCoffeeName() {

        // given

        // setup function

        // when
        Coffee found = underTest.getByName(name);

        // then
        assertThat(found).isNotNull();

    }

    @Test
    void itShouldNotGetByCoffeeName() {

        // given

        // setup function

        // when
        Coffee found = underTest.getByName("");

        // then
        assertThat(found).isNull();

    }

    @Test
    void itShouldFindByIdGreaterThan() {

        // given

        // setup function

        // when
        List<Coffee> found = underTest.findByIdGreaterThan(-1);

        // then
        assertThat(found).isNotEmpty();

    }

    @Test
    void itShouldNotFindByIdGreaterThan() {

        // given

        // setup function

        // when
        List<Coffee> found = underTest.findByIdGreaterThan(9999);

        // then
        assertThat(found).isEmpty();

    }

    @Test
    void itShouldFindByIdIsLessThan() {

        // given

        // setup function

        // when
        List<Coffee> found = underTest.findByIdIsLessThan(9999);

        // then
        assertThat(found).isNotEmpty();

    }

    @Test
    void itShouldNotFindByIdLessThan() {

        // given

        // setup function

        // when
        List<Coffee> found = underTest.findByIdIsLessThan(-1);

        // then
        assertThat(found).isEmpty();

    }

    @Test
    void itShouldFindByRecipe() {

        // given

        // setup function

        // when
        List<Coffee> found = underTest.findByRecipe(recipe);

        // then
        assertThat(found).isNotEmpty();


    }

    @Test
    void itShouldNotFindByRecipe() {

        // given

        // setup function

        // when
        List<Coffee> found = underTest.findByRecipe(null);

        // then
        assertThat(found).isEmpty();


    }

    @Test
    void itShouldFindByCustomer() {

        // given

        // setup function

        // when
        List<Coffee> found = underTest.findByCustomer(customer);

        // then
        assertThat(found).isNotEmpty();


    }

    @Test
    void itShouldNotFindByCustomer() {

        // given

        // setup function

        // when
        List<Coffee> found = underTest.findByCustomer(null);

        // then
        assertThat(found).isEmpty();


    }
}