package com.github.javaclub.springdata.jdbc;

import java.util.List;

import com.github.javaclub.springdata.jdbc.data.CustomerRepository;
import com.github.javaclub.springdata.jdbc.data.RegionRepository;
import com.github.javaclub.springdata.jdbc.model.Address;
import com.github.javaclub.springdata.jdbc.model.Customer;
import com.github.javaclub.springdata.jdbc.model.Hero;
import com.github.javaclub.springdata.jdbc.model.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootTest
class SandboxTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JdbcAggregateTemplate aggregateTemplate;

    @Autowired
    private RegionRepository repository;

    @Test
    void shouldCreateCustomer() {

        var america = new Region().continent("America");
        repository.save(america);

        var customerApple = new Customer()
            .customerName("Apple")
            .address(new Address().country("Ukraine").city("Lviv"))
            .addHero(new Hero().name("Batman"))
            .addHero(new Hero().name("Superman"))
            .region(AggregateReference.to(america.id()));
        var persisted = customerRepository.save(customerApple);


        customerApple.addHero(new Hero().name("Lady-Cat"));
        customerRepository.save(customerApple);

        Assertions.assertTrue(persisted.id() != null);
        System.out.println(persisted.id());


        var customer = customerRepository.findById(customerApple.id()).orElseThrow();
        System.out.println("customer = " + customer);

        var id = customer.region().getId();

        var customersByContinent = customerRepository.findCustomersByContinent(america.continent());
        System.out.println("customersByContinent = " + customersByContinent);

    }

}
