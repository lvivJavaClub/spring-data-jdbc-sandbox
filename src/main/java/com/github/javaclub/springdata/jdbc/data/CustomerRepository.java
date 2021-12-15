package com.github.javaclub.springdata.jdbc.data;

import java.util.UUID;

import com.github.javaclub.springdata.jdbc.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}
