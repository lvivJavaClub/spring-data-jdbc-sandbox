package com.github.javaclub.springdata.jdbc.data;

import java.lang.reflect.Type;
import java.sql.JDBCType;

import com.github.javaclub.springdata.jdbc.model.Address;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.convert.JdbcValue;

@UtilityClass
public class AddressConvertor {

    @WritingConverter
    public enum AddressToStringConvertor implements Converter<Address, JdbcValue> {

        INSTANCE;

        @Override
        public JdbcValue convert(Address source) {
            return JdbcValue.of(new Gson().toJson(source), JDBCType.VARCHAR);
        }
    }

    @ReadingConverter
    public enum StringToAddressConvertor implements Converter<String, Address> {
        INSTANCE;

        @Override
        public Address convert(String source) {
            if (source == null || source.isEmpty()) {
                return null;
            }
            return new Gson().fromJson(source, (Type) Address.class);
        }
    }


}
