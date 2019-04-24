package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductNameLengthValidationRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductNameLengthValidationRule victim = new ProductNameLengthValidationRule();

    private ProductDTO input;

    @Test
    public void shouldThrowProductNameLengthValidationException() {
        input = productDTO("a");

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name length can not be less 3 symbols or more than 32");

        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = productDTO("test");

        victim.validate(input);
    }

    private ProductDTO productDTO(String name) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        return productDTO;
    }
}