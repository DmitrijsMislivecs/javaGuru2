package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryDatabase;

import org.springframework.stereotype.Component;

@Component
public class DefaultProductService implements ProductService {
    private ProductInMemoryDatabase database;

    public DefaultProductService(ProductInMemoryDatabase database) {
        this.database = database;
    }
    @Override
    public Product findProductById(Long id) {
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
