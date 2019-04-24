package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;

import org.springframework.stereotype.Component;

@Component
public class ProductNotNullValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDTO product) {
        if (product == null) {
            throw new ProductValidationException("Product cannot be null");
        }
    }
}
