package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultProductService implements ProductService {

    private ProductDataBase database;

    @Autowired
    public DefaultProductService(ProductDataBase database) {
        this.database = database;
    }

    @Override
    public Product findProductById(Long id) {
        return database.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found. Id: " + id));
    }

    @Override
    public Long create(Product product) {
        database.insert(product);
        return product.getId();
    }
}
