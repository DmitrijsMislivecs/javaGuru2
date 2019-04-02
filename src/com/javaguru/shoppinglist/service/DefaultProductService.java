package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryDatabase;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class DefaultProductService implements ProductService {

    private ProductValidationService productValidationService = new ProductValidationService();
    private ProductInMemoryDatabase database = new ProductInMemoryDatabase();

    public Product findProductById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be not null");
        }
        return database.findProductById(id);
    }

    public Long create(Product product) {

        productValidationService.validate(product);
        database.insert(product);
        return product.getId();
    }
}
