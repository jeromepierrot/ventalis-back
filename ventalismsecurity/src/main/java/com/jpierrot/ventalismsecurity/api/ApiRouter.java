package com.jpierrot.ventalismsecurity.api;

public interface ApiRouter {

        String ROOT_PREFIX = "/api/v1";
        String REST_LOGIN = ROOT_PREFIX + "/auth";
        String REST_AUTH = "/authenticate";
        String REST_REGISTER = "/register";
        String REST_REGISTER_USER = REST_REGISTER;
//        String REST_REGISTER_USER = REST_REGISTER + "/new";
        String REST_REGISTER_EMPLOYEE = REST_REGISTER + "/employee";
        String ROUTING_USER = "/user";
        String ROUTING_INTRANET = "/intranet";
        String ROUTING_ADMIN = "/admin";
        String REST_ERROR = ROOT_PREFIX + "/error";
}
