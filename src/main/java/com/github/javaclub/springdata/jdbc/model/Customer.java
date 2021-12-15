package com.github.javaclub.springdata.jdbc.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class Customer {

    @Id
    private UUID id;

    @Column("NAME")
    private String customerName;

    private Address address;

    private final Set<Hero> heroes = new HashSet<>();

    private AggregateReference<Region, Integer> region;

    @PersistenceConstructor
    public Customer(String customerName, Address address, List<Hero> heroes) {
        this.customerName = customerName;
        this.address = address;
        if (heroes != null && !heroes.isEmpty()) {
            heroes.forEach(this::addHero);
        }
    }

    public Customer addHero(Hero hero) {
        hero.customer(this);
        heroes.add(hero);
        return this;
    }

}
