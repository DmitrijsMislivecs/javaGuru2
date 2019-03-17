package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryDatabase {
    private Map<Long, Product> products = new HashMap<>();
    private Long PRODUCT_ID_SEQUENCE = 0L;


    public Long insert(Product product) {
        product.setId(PRODUCT_ID_SEQUENCE);
        products.put(PRODUCT_ID_SEQUENCE, product);
        return PRODUCT_ID_SEQUENCE++;
    }

    public Product findProductById(Long id) {
        return products.get(id);
    }
}
