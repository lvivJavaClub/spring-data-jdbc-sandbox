package com.github.javaclub.springdata.jdbc.data;

import com.github.javaclub.springdata.jdbc.model.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Integer> {
}
