package com.jpierrot.ventalismproducts.webservice.exceptions;


public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
