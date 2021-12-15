package com.github.javaclub.springdata.jdbc.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class Address {

    private String country;
    private String city;

}
