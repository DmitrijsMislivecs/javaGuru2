package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductNotNullValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product cannot be null");
        }
    }
}
