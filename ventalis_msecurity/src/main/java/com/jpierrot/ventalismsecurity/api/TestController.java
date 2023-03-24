package com.jpierrot.ventalismsecurity.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/test")
public class TestController {

    @GetMapping()
    public ResponseEntity<String> endpointTest1() {
        return ResponseEntity.ok("Secured endpoint 1");
    }

    @GetMapping("/2")
    public ResponseEntity<String> endpointTest2() {
        return ResponseEntity.ok("Secured endpoint 2");
    }

}