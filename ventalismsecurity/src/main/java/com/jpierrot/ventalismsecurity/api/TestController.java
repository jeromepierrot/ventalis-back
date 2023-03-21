package com.jpierrot.ventalismsecurity.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/endpoint-test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> endpoint_test() {
        return ResponseEntity.ok("Secured endpoint");
    }

}