package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.DefaultProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final DefaultProductService productService;

    public ProductController(DefaultProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({ProductDTO.Create.class}) @RequestBody ProductDTO productDTO,
                                          UriComponentsBuilder builder) {
        Long id = productService.createProduct(productDTO);
        return ResponseEntity.created(builder.path("/products/{id}").buildAndExpand(id).toUri()).build();
        /*Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setDiscount(productDTO.getDiscount());
        product.setDescription(productDTO.getDescription());
        productService.createProduct(product);
        return ResponseEntity.ok(product);*/
    }
/*
    @PostMapping
    public void delete(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        return;
    }*/

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        //Product product = productService.findProductById(id);
        return productService.findProductById(id);
    }
}
