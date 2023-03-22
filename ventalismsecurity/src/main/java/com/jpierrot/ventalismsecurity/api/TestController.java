package com.jpierrot.ventalismsecurity.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/endpoint-test")
@RequiredArgsConstructor
public class TestController {

   // private final AuthService authService;

    @GetMapping
    public ResponseEntity<String> endpointTest() {
        return ResponseEntity.ok("Secured endpoint");
    }

/*    @GetMapping("/secured")
    public ResponseEntity<String> endpointTest() {
        return ResponseEntity.ok("secured endpoint");
    }*/

/*    @PostMapping("/reg")
    public ResponseEntity<AuthResponse> registerTest(
            @RequestBody UserRegisterRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }*/

/*    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> authenticateTest(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }*/

}