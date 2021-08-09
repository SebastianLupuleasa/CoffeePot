package com.lupuleasa.coffee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuantifiedCoffeeRepository extends JpaRepository<QuantifiedCoffee,Integer> {

    QuantifiedCoffee getByname(String name);

    @Query( "select cof from QuantifiedCoffee cof where cof.user_id = :id" )
    List<QuantifiedCoffee> findByCustomerId(int id);

}