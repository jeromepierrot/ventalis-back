package com.jpierrot.ventalismproducts.api.webservice.exceptions;


public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
