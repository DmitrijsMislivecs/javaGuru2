package com.javaguru.shoppinglist.service.action;

import com.javaguru.shoppinglist.service.ProductService;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class FindProductByIdAction implements Action {

    private static final String ACTION_NAME = "Find by ID";

    private final ProductService productService;

    public FindProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        Optional<Object> response = productService.findProductById(id);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
