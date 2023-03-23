package com.jpierrot.ventalismproducts.api;

public interface ApiRouter {

        String ROOT_PREFIX = "";
        String REST_API_PREFIX = ROOT_PREFIX + "/api";
        String REST_CATALOG = ROOT_PREFIX + "/catalog";
        String REST_PRODUCT = REST_CATALOG + "/products";
        String REST_CATEGORY = REST_CATALOG + "/categories";
        String REST_ERROR = ROOT_PREFIX + "/error";
}
