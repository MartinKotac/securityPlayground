package com.example.securityPlayground.config;

import com.example.securityPlayground.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbInsert implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DbInsert(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        var userAdmin = User.builder()
                .email("something@mail.com")
                .firstName("Martin")
                .lastName("Kotac")
                .role(Role.ADMIN)
                .password(passwordEncoder.encode("dummy"))
                .build();
        this.userRepository.save(userAdmin);

        System.out.println(userAdmin.getAuthorities());

        var userManager = User.builder()
                .email("manager@mail.com")
                .firstName("Nikola")
                .lastName("Bojkos")
                .role(Role.MANAGER)
                .password(passwordEncoder.encode("1234"))
                .build();
        this.userRepository.save(userManager);

        System.out.println(userManager.getAuthorities());
    }
}
