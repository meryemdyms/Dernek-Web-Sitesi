package org.example.dernekwebsitesi.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dernekwebsitesi.jwt.AuthRequest;
import org.example.dernekwebsitesi.jwt.AuthResponse;
import org.example.dernekwebsitesi.model.User;
import org.example.dernekwebsitesi.repository.UserRepository;
import org.example.dernekwebsitesi.service.AuthService;
import org.example.dernekwebsitesi.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    @Override
    public AuthResponse register(AuthRequest req) {
        var user = User.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .role(req.getRole())        // DTO’dan gelen role
                .build();

        userRepo.save(user);
        String token = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse authenticate(AuthRequest req) {
        // 1) Kimlik doğrulaması
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsername(),
                        req.getPassword()
                )
        );

        // 2) Kullanıcıyı çek, token üret
        var user = userRepo.findByUsername(req.getUsername())
                .orElseThrow(); // veya kendi BaseException’ınızla fırlatın

        String token = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
