package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.ProductDataBase;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DefaultProductService {

    private final ProductDataBase database;
    private final ProductValidationService productValidationService;
    private final ProductConverter productConverter;

    @Autowired
    public DefaultProductService(ProductDataBase database, ProductValidationService productValidationService,
                                 ProductConverter productConverter) {
        this.database = database;
        this.productValidationService = productValidationService;
        this.productConverter = productConverter;
    }

    public ProductDTO findProductById(Long id) {
        return database.findProductById(id)
                .map(productConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("Product not found. Id: " + id));
    }

    public Long createProduct(ProductDTO productDTO) {
        productValidationService.validate(productDTO);
        Product product = productConverter.convert(productDTO);
        return database.save(product);
    }
}
