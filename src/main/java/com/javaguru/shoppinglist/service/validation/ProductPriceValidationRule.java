package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {

        if (product.getPrice().compareTo(new BigDecimal(0)) <= 0) {
            throw new ProductValidationException("Product price should be more than 0");
        }
    }
}
