package com.lupuleasa.coffee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {

    @Query( "select pur from Purchase pur where pur.customer = :c" )
    List<Purchase> findByCustomer(Customer c);

}
