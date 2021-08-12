package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Coffee;
import com.lupuleasa.coffee.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {
    Optional<Coffee> findByname(String name);

    List<Coffee> findByIdGreaterThan(Integer id);

    List<Coffee> findByIdIsLessThan(Integer id);

    @Query( "select cof from Coffee cof where cof.customer = :c" )
    List<Coffee> findByCustomer(Customer c);

}