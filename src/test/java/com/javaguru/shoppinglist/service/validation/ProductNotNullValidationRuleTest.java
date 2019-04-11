package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductNotNullValidationRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductNotNullValidationRule victim = new ProductNotNullValidationRule();

    private Product input;

    @Test
    public void shouldThrowProductNotNullValidationException() {
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product cannot be null");

        victim.validate(null);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product("New Product");
        victim.validate(input);
    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}