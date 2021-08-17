package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Coffee;
import com.lupuleasa.coffee.models.Customer;
import com.lupuleasa.coffee.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {

    Coffee getByName(String name);

    List<Coffee> findByIdGreaterThan(Integer id);

    List<Coffee> findByIdIsLessThan(Integer id);

    List<Coffee> findByRecipe(Recipe recipe);

    @Query( "select cof from Coffee cof where cof.customer = :c" )
    List<Coffee> findByCustomer(Customer c);

}
