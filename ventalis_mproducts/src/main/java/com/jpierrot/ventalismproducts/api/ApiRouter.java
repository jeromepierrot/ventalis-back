package com.jpierrot.ventalismproducts.api;

public interface ApiRouter {
        String REST_PREFIX = "/api";
        String REST_CATALOG = "/products";
        String REST_PRODUCT = REST_CATALOG + "/product";
        String REST_CATEGORY = "/categories";

        String REST_ERROR = "/error";
}
