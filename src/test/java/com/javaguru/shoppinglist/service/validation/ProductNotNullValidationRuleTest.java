package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductNotNullValidationRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductNotNullValidationRule victim = new ProductNotNullValidationRule();

    private ProductDTO input;

    @Test
    public void shouldThrowProductNotNullValidationException() {
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product cannot be null");

        victim.validate(null);
    }

    @Test
    public void shouldValidateSuccess() {
        input = productDTO("New Product");
        victim.validate(input);
    }

    private ProductDTO productDTO(String name) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        return productDTO;
    }
}