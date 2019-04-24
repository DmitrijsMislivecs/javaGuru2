package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.config.ApplicationConfig;
import com.javaguru.shoppinglist.console.ConsoleUI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ShoppingListApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConsoleUI ui = context.getBean(ConsoleUI.class);
        ui.start();
    }
}
