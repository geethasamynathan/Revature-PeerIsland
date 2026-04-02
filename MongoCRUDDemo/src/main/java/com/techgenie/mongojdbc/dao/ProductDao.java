package com.techgenie.mongojdbc.dao;

import com.techgenie.mongojdbc.model.Product;

import java.util.List;
public interface ProductDao {

    void testConnection();
    List<Product> findAll();
    Product findById(int id);
    void insert(Product product);
    void update(Product product);
    void deleteById(int id);
}
