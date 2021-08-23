package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Ingredient;
import io.swagger.models.auth.In;
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
class IngredientRepositoryTest {

    private String ingredientName;

    @Autowired
    private IngredientRepository underTest;


    @BeforeEach
    void setUp() {


       ingredientName="ciocolata";
       Ingredient ingredient = new Ingredient();
       ingredient.setName(ingredientName);

       underTest.save(ingredient);
    }

    @Test
    void itShouldFindByIngredientName() {

        // given

        // setUp function

        //when
        Optional<Ingredient> found = underTest.findByname(ingredientName);


        //then
        assertThat(found).isNotEmpty();

    }


    @Test
    void itShouldNotFindByIngredientName() {

        // given

        // setUp function

        //when
        Optional<Ingredient> found = underTest.findByname("");


        //then
        assertThat(found).isEmpty();

    }

    @Test
    void itShouldFindByIds() {

        // given

        // setUp function

        int[] ids = {underTest.findByname(ingredientName).get().getId()};

        //when
        List<Ingredient> found = underTest.findByIds(ids);


        //then
        assertThat(found).isNotEmpty();

    }

    @Test
    void itShouldNotFindByIds() {

        // given

        // setUp function

        int[] ids = {};

        //when
        List<Ingredient> found = underTest.findByIds(ids);


        //then
        assertThat(found).isEmpty();

    }
}