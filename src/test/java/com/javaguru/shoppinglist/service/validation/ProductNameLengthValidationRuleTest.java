package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductNameLengthValidationRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProductNameLengthValidationRule victim = new ProductNameLengthValidationRule();

    private Product input;

    @Test
    public void shouldThrowProductNameLengthValidationException() {
        input = product("a");

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name length can not be less 3 symbols or more than 32");

        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product("test");

        victim.validate(input);
    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}