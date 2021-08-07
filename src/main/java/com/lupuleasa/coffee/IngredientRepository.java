package com.lupuleasa.coffee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
    Optional<Ingredient> findByname(String name);

    @Query( "select i from Ingredient i where i.id in :ids" )
    Optional<Ingredient> findByIds(int[] ids);
}
