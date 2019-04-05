package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryDatabase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameUniqueValidationRuleTest {

    @Mock
    private ProductInMemoryDatabase database;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @InjectMocks
    private ProductNameUniqueValidationRule victim;

    @Test
    public void shouldThrowProductNameUniqueValidationException() {

        when(database.isExistingProductByName("test")).thenReturn(true);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name should be unique!");

        victim.validate(product());
    }

    private Product product(){
        Product product = new Product();
        product.setName("test");
        return product;
    }
}