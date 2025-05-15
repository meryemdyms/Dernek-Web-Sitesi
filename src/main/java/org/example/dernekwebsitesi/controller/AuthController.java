// src/main/java/org/example/dernekwebsitesi/controller/AuthController.java
package org.example.dernekwebsitesi.controller;

import org.example.dernekwebsitesi.jwt.AuthRequest;
import org.example.dernekwebsitesi.jwt.AuthResponse;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

public interface AuthController {

    ResponseEntity<AuthResponse> register( AuthRequest request);

    ResponseEntity<AuthResponse> authenticate( AuthRequest request);
}
