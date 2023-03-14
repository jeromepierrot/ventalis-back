package com.jpierrot.ventalismproducts.webservice.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException (String errorMessage) {
        super(errorMessage);
    }
}
