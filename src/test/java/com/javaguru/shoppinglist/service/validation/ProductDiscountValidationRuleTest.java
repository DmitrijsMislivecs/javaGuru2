package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;


public class ProductDiscountValidationRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    private Product input;

    @Test
    public void shouldThrowProductDiscountValidationException() {
        input = product(new BigDecimal(101));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Discount can not be less than 0 or more than 100%");

        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product(new BigDecimal(1));

        victim.validate(input);
    }

    private Product product(BigDecimal discount) {
        Product product = new Product();
        product.setDiscount(discount);
        product.setPrice(new BigDecimal(20));
        return product;
    }
}