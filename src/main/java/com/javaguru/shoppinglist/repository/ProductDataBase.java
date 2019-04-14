package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductDataBase {

    Long insert(Product product);

    Optional<Object> findProductById(Long id);

    boolean isExistingProductByName(String name);

}
