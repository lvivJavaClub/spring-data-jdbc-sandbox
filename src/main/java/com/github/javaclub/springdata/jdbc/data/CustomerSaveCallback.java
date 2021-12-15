package com.github.javaclub.springdata.jdbc.data;

import java.util.UUID;

import com.github.javaclub.springdata.jdbc.model.Customer;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.stereotype.Component;

@Component
public class CustomerSaveCallback implements BeforeSaveCallback<Customer> {


    @Override
    public Customer onBeforeSave(Customer aggregate, MutableAggregateChange<Customer> aggregateChange) {
        if (aggregate.id() == null) {
            aggregate.id(UUID.randomUUID());
        }
        return aggregate;
    }
}
