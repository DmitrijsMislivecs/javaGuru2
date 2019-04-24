package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;


public class ProductDiscountValidationRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    private ProductDTO input;

    @Test
    public void shouldThrowProductDiscountValidationException() {
        input = productDTO(new BigDecimal(101));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Discount can not be less than 0 or more than 100%");

        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = productDTO(new BigDecimal(1));

        victim.validate(input);
    }

    private ProductDTO productDTO(BigDecimal discount) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDiscount(discount);
        productDTO.setPrice(new BigDecimal(20));
        return productDTO;
    }
}