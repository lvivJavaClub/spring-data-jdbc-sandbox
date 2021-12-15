package com.github.javaclub.springdata.jdbc.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Accessors(fluent = true)
@Table("CUSTOMER_FAVOURITE_HERO")
public class Hero {

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Transient
    private Customer customer;

}
