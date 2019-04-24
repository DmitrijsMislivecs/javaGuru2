package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.repository.ProductDataBase;

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
    private ProductDataBase database;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @InjectMocks
    private ProductNameUniqueValidationRule victim;

    @Test
    public void shouldThrowProductNameUniqueValidationException() {

        when(database.isExistingProductByName("test")).thenReturn(true);
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product name should be unique!");

        victim.validate(productDTO());
    }

    private ProductDTO productDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("test");
        return productDTO;
    }
}