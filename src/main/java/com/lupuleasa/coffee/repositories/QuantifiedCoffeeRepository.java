package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.QuantifiedCoffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantifiedCoffeeRepository extends JpaRepository<QuantifiedCoffee,Integer> {

    QuantifiedCoffee getByname(String name);

    @Query( "select cof from QuantifiedCoffee cof where cof.uid = :id" )
    List<QuantifiedCoffee> findByCustomerId(int id);

    boolean existsByName(String name);

    QuantifiedCoffee getQuantifiedCoffeeByNameAndUid(String name , int user_id);

    }