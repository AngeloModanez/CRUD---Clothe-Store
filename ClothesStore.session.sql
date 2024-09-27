CREATE DATABASE IF NOT EXISTS db_jdbc_ClothesStore;
USE db_jdbc_ClothesStore;
CREATE TABLE clothes (
    id int auto_increment,
    quantity int,
    sku varchar(20),
    description varchar(50),
    price float,
    max_discount float,
    PRIMARY KEY(id)
);