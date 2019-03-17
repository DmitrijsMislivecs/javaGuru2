package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNotNullValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product cannot be null");
        }
    }
}
