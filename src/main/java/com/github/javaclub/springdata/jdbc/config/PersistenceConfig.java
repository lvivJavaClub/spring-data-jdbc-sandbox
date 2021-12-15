package com.github.javaclub.springdata.jdbc.config;

import java.util.List;

import com.github.javaclub.springdata.jdbc.data.AddressConvertor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

@Configuration
public class PersistenceConfig extends AbstractJdbcConfiguration {

    @Override
    protected List<?> userConverters() {
        return List.of(
            AddressConvertor.AddressToStringConvertor.INSTANCE,
            AddressConvertor.StringToAddressConvertor.INSTANCE
        );
    }


}
