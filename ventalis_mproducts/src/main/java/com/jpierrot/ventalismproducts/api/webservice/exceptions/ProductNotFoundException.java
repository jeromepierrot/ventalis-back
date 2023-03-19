package com.jpierrot.ventalismproducts.api.webservice.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException (String errorMessage) {
        super(errorMessage);
    }
}
