package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if ((product.getDiscount().compareTo(new BigDecimal(100)) > 0) || (product.getDiscount().compareTo(new BigDecimal(0)) < 0))  {
            throw new ProductValidationException("Discount can not be less than 0 or more than 100%");
        }

        if (product.getPrice().compareTo(new BigDecimal(20)) < 0) {
            throw new ProductValidationException("To get discount price of the product should be more than 20$");
        }
    }
}
