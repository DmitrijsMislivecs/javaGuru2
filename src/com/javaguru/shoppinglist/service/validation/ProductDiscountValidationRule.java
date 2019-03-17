package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getDiscount().compareTo(new BigDecimal(100)) > 0) {
            throw new ProductValidationException("Discount can not be more than 100%");
        }
    }
}
