package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {
    Optional<Recipe> findByname(String name);
}
