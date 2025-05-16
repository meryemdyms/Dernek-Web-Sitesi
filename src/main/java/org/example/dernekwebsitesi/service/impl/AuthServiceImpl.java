package org.example.dernekwebsitesi.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dernekwebsitesi.jwt.AuthRequest;
import org.example.dernekwebsitesi.jwt.AuthResponse;
import org.example.dernekwebsitesi.model.User;
import org.example.dernekwebsitesi.repository.UserRepository;
import org.example.dernekwebsitesi.service.AuthService;
import org.example.dernekwebsitesi.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private  JwtService jwtService;
    @Autowired
    private  AuthenticationManager authManager;

    @Override
    public AuthResponse register(AuthRequest request) {
        // 1) Yeni user oluştur
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())             // AuthRequest’e role eklediyseniz
                .build();
        userRepository.save(user);

        // 2) Token üret
        String jwt = jwtService.generateToken(user);

        return new AuthResponse(jwt, "Kayıt başarılı");
    }


    @Override
    public AuthResponse authenticate(AuthRequest request) {
        // 1) AuthenticationManager ile username/password doğrula
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // 2) UserDetails çağır (yani loadUserByUsername)
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı"));

        // 3) Token üret
        String jwt = jwtService.generateToken(user);

        return new AuthResponse(jwt, "Authentication başarılı");
    }
}
