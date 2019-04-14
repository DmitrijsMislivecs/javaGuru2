package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultProductService implements ProductService {

    private ProductDataBase database;

    @Autowired
    public DefaultProductService(ProductDataBase database) {
        this.database = database;
    }

    @Override
    public Optional<Object> findProductById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be not null");
        }
        return database.findProductById(id);
    }

    @Override
    public Long create(Product product) {
        database.insert(product);
        return product.getId();
    }
}
