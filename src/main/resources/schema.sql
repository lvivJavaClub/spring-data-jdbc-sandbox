CREATE TABLE CUSTOMER (
    id VARCHAR(36) PRIMARY KEY,
    name varchar(255),
    address varchar(2000),
    region varchar(36)
);

CREATE TABLE customer_favourite_hero (
    customer VARCHAR(36),
    name varchar(255)
);

CREATE TABLE region (
    id integer auto_increment,
    continent varchar(50)
);
