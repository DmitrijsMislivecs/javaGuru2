package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductValidationService {

    private Set<ProductValidationRule> validationRules;

    @Autowired
    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(ProductDTO productDTO) {
        validationRules.forEach(s -> s.validate(productDTO));
    }
}
