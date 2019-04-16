package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductDataBase {

    Long save(Product product);

    void update(Product product);

    Optional<Product> findProductById(Long id);

    boolean isExistingProductByName(String name);

    void delete(Product product);

}
