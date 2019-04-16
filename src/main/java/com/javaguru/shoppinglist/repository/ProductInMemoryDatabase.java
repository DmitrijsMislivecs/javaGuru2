package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("inmemorydb")
public class ProductInMemoryDatabase implements ProductDataBase {

    private Map<Long, Product> products = new HashMap<>();
    private Long PRODUCT_ID_SEQUENCE = 0L;

    @Override
    public Long insert(Product product) {
        product.setId(PRODUCT_ID_SEQUENCE);
        products.put(PRODUCT_ID_SEQUENCE, product);
        return PRODUCT_ID_SEQUENCE++;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public boolean isExistingProductByName(String name) {
        for (Product p : products.values()) {
            if (name.equals(p.getName())) {
                return true;
            }
        }
        return false;
    }
}
