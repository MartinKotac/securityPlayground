package com.example.securityPlayground.config;

import com.example.securityPlayground.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbInsert implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ResolutionRepository resolutionRepository;
    private final PasswordEncoder passwordEncoder;

    public DbInsert(UserRepository userRepository, ResolutionRepository resolutionRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.resolutionRepository = resolutionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
