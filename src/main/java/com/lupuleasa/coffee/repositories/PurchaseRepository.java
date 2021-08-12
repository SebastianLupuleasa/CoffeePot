package com.lupuleasa.coffee.repositories;

import com.lupuleasa.coffee.models.Customer;
import com.lupuleasa.coffee.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {

    @Query( "select pur from Purchase pur where pur.customer = :c" )
    List<Purchase> findByCustomer(Customer c);

}
