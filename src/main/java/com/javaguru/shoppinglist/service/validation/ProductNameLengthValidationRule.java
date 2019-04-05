package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameLengthValidationRule implements ProductValidationRule {
    private int MIN_PRODUCT_NAME_LENGTH = 3;
    private int MAX_PRODUCT_NAME_LENGTH = 32;

    @Override
    public void validate(Product product) {
        if ((product.getName().length() < MIN_PRODUCT_NAME_LENGTH) || (product.getName().length() > MAX_PRODUCT_NAME_LENGTH)) {
            throw new ProductValidationException("Product name length can not be less 3 symbols or more than 32");
        }
    }
}
