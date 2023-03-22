package com.jpierrot.ventalismsecurity.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/endpoint-test")
@RequiredArgsConstructor
public class TestController {

    @GetMapping
    public ResponseEntity<String> endpointTest() {
        return ResponseEntity.ok("Non-secured endpoint");
    }

}