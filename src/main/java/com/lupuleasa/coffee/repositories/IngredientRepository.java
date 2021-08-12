package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
    Optional<Ingredient> findByname(String name);

    @Query( "select i from Ingredient i where i.id in :ids" )
    List<Ingredient> findByIds(int[] ids);
}
