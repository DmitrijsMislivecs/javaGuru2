package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.repository.ProductDataBase;

import org.springframework.stereotype.Component;

@Component
public class ProductNameUniqueValidationRule implements ProductValidationRule {

    private final ProductDataBase database;

    ProductNameUniqueValidationRule(ProductDataBase database) {
        this.database = database;
    }

    @Override
    public void validate(ProductDTO product) {
        if (database.isExistingProductByName(product.getName())){
            throw new ProductValidationException("Product name should be unique!");
        }
    }
}
