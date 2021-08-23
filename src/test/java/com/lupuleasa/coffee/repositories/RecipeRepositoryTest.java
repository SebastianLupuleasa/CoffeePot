package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Recipe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import java.util.Optional;

@DataJpaTest
class RecipeRepositoryTest {

    private String recipeName;

    @Autowired
    private RecipeRepository underTest;


    @BeforeEach
    void setUp() {

        recipeName="recipeTest";
        Recipe recipe = new Recipe();
        recipe.setName(recipeName);

        underTest.save(recipe);
    }

    @Test
    void itShouldFindByRecipeName() {

        // given

        // setUp function

        //when
        Optional<Recipe> found = underTest.findByname(recipeName);


        //then
        assertThat(found).isNotEmpty();

    }


    @Test
    void itShouldNotFindByRecipeName() {

        // given

        // setUp function

        //when
        Optional<Recipe> found = underTest.findByname("");


        //then
        assertThat(found).isEmpty();

    }
}