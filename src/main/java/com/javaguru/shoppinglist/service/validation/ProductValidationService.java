package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();

    @Autowired
    public ProductValidationService(ProductInMemoryDatabase database) {
        validationRules.add(new ProductNotNullValidationRule());
        validationRules.add(new ProductNameLengthValidationRule());
        validationRules.add(new ProductPriceValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductNameUniqueValidationRule(database));
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }
}
