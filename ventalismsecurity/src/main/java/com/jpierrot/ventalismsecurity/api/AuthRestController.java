package com.jpierrot.ventalismsecurity.api;

import com.jpierrot.ventalismsecurity.models.auth.*;
import com.jpierrot.ventalismsecurity.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiRouter.REST_LOGIN)
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthRestController {
    private final AuthService service;

    @PostMapping(ApiRouter.REST_REGISTER_USER)
    public ResponseEntity<AuthResponse> register (
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping(ApiRouter.REST_REGISTER_EMPLOYEE)
    public ResponseEntity<AuthResponse> register (
            @RequestBody EmployeeRegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping(ApiRouter.REST_AUTH)
    public ResponseEntity<AuthResponse> authenticate (
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
