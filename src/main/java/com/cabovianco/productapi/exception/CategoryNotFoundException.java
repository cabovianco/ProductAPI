package com.cabovianco.productapi.exception;

public class CategoryNotFoundException extends Exception {

    public CategoryNotFoundException() {
        super("Category not found");
    }

}
