package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;

public interface ProductValidationRule {

    void validate (ProductDTO product) throws ProductValidationException;
}
