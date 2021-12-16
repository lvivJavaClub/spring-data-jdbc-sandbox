package com.github.javaclub.springdata.jdbc.data;

import java.util.List;
import java.util.UUID;

import com.github.javaclub.springdata.jdbc.model.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {


    @Query("""
        SELECT c.* 
          FROM CUSTOMER c
               JOIN REGION r ON r.id = c.region
          WHERE r.continent = :continent
    """)
    List<Customer> findCustomersByContinent(@Param("continent") String continent);

}
