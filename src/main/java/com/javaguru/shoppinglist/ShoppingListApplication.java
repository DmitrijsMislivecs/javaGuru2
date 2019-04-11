package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductInMemoryDatabase;
import com.javaguru.shoppinglist.service.DefaultProductService;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.action.Action;
import com.javaguru.shoppinglist.service.action.CreateProductAction;
import com.javaguru.shoppinglist.service.action.ExitAction;
import com.javaguru.shoppinglist.service.action.FindProductByIdAction;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.util.ArrayList;
import java.util.List;

class ShoppingListApplication {

    public static void main(String[] args) {
        ProductInMemoryDatabase database = new ProductInMemoryDatabase();
        ProductService productService = new DefaultProductService(database);
        ProductValidationService productValidationService = new ProductValidationService(database);

        Action exitAction = new ExitAction();
        Action createUserAction = new CreateProductAction(productService, productValidationService);
        Action findUserByIdAction = new FindProductByIdAction(productService);

        List<Action> actions = new ArrayList<>();
        actions.add(findUserByIdAction);
        actions.add(createUserAction);
        actions.add(exitAction);

        ConsoleUI ui = new ConsoleUI(actions);
        ui.start();
    }
}
