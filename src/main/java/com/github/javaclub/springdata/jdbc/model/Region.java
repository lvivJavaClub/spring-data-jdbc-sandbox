package com.github.javaclub.springdata.jdbc.model;

import java.util.UUID;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Data
@Accessors(fluent = true)
public class Region {

    @Id
    private Integer id;

    private String continent;

}
