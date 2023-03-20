package com.jpierrot.ventalismsecurity.api;

public interface ApiRouter {

        String ROOT_PREFIX = "";
        String REST_API_PREFIX = ROOT_PREFIX + "/api";
        String REST_LOGIN = ROOT_PREFIX + "/login";
        String REST_AUTH = REST_LOGIN + "/auth";
        String REST_USER = "/user";
        String REST_INTRANET = "/intranet";
        String REST_ADMIN = "/admin";
        String REST_ERROR = ROOT_PREFIX + "/error";
}
