package org.example.dernekwebsitesi.service;

import org.example.dernekwebsitesi.jwt.AuthRequest;
import org.example.dernekwebsitesi.jwt.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse authenticate(AuthRequest request);
}