package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if ((product.getName().length() < 3) || (product.getName().length() > 32)) {
            throw new ProductValidationException("Product name length can not be less 3 symbols or more than 32");
        }
    }
}
