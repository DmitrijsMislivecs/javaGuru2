package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DefaultProductService implements ProductService {

    private Map<Long, Product> database = new HashMap<>();
    private Long PRODUCT_ID_SEQUENCE = 0L;

    public Product findBy(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be not null");
        }
        return database.get(id);
    }

    @Override
    public Long create(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot be null");
        }

        if ((product.getName().length() < 3) || (product.getName().length() > 32)) {
            throw new IllegalArgumentException("Product name length can not be less 3 symbols or more than 32");
        }

        if (product.getPrice().compareTo(new BigDecimal(0)) <= 0) {
            throw new IllegalArgumentException("Product price should be more than 0");
        }

        if (product.getDiscount().compareTo(new BigDecimal(100)) > 0) {
            throw new IllegalArgumentException("Discount can not be more than 100%");
        }

        product.setId(PRODUCT_ID_SEQUENCE);

        database.put(PRODUCT_ID_SEQUENCE, product);
        return PRODUCT_ID_SEQUENCE++;
    }

}
