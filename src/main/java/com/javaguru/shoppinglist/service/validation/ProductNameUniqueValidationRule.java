package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryDatabase;


public class ProductNameUniqueValidationRule implements ProductValidationRule {

    private final ProductInMemoryDatabase database;

    ProductNameUniqueValidationRule(ProductInMemoryDatabase database) {
        this.database = database;
    }

    @Override
    public void validate(Product product) {
        if (database.isExistingProductByName(product.getName())){
            throw new ProductValidationException("Product name should be unique!");
        }
    }
}
