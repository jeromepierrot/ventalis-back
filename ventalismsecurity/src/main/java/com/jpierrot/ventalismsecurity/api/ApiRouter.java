package com.jpierrot.ventalismsecurity.api;

public interface ApiRouter {

        String ROOT_PREFIX = "/api";
        String REST_LOGIN = ROOT_PREFIX + "/auth";
        String REST_AUTH = "/authenticate";
        String REST_REGISTER = "/register/new";
        String REST_REGISTER_USER = REST_REGISTER;
        String REST_REGISTER_EMPLOYEE = REST_REGISTER + "/employee";
        String REST_REGISTER_ADMIN = REST_REGISTER + "/admin";
        String ROUTING_USER = "/user";
        String ROUTING_INTRANET = "/intranet";
        String ROUTING_ADMIN = "/admin";
        String REST_ERROR = ROOT_PREFIX + "/error";
}
