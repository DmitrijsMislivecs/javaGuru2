package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDTO product) {

        if (product.getPrice().compareTo(new BigDecimal(0)) <= 0) {
            throw new ProductValidationException("Product price should be more than 0");
        }
    }
}
