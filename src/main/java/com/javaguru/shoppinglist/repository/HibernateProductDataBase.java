package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import java.util.Optional;

@Profile("hibernate")
public class HibernateProductDataBase implements ProductDataBase {


    @Override
    public Long insert(Product product) {
        return null;
    }

    @Override
    public Optional<Object> findProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean isExistingProductByName(String name) {
        return false;
    }
}
