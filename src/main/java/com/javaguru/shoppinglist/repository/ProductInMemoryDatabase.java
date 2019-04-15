package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
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

    public boolean isExistingProductByName(String name) {
        for (Product p : products.values()) {
            if (name.equals(p.getName())) {
                return true;
            }
        }
        return false;
    }
}
