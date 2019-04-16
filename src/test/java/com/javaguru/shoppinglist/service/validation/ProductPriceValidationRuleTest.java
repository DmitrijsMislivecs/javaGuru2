package com.javaguru.shoppinglist.service.validation;

//import com.javaguru.shoppinglist.domain.Product;

import com.javaguru.shoppinglist.dto.ProductDTO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceValidationRuleTest {


    @Spy
    private ProductPriceValidationRule victim;

    private ProductDTO input;

    @Test
    public void shouldThrowProductPriceValidationException() {
        input = productDTO(new BigDecimal(0));

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product price should be more than 0");
    }

    @Test
    public void shouldValidateSuccess() {
        input = productDTO(new BigDecimal(1));

        victim.validate(input);
    }

    private ProductDTO productDTO(BigDecimal price) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setPrice(price);
        return productDTO;
    }
}