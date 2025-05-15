package org.example.dernekwebsitesi.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dernekwebsitesi.jwt.AuthRequest;
import org.example.dernekwebsitesi.jwt.AuthResponse;
import org.example.dernekwebsitesi.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthControllerImpl {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthRequest req) {
        return ResponseEntity
                .status(201)
                .body(authService.register(req));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @Valid AuthRequest req) {
        return ResponseEntity.ok(authService.authenticate(req));
    }
}


