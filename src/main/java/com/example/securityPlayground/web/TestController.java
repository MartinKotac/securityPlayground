package com.example.securityPlayground.web;


import com.example.securityPlayground.model.Resolution;
import com.example.securityPlayground.model.ResolutionRepository;
import com.example.securityPlayground.model.User;
import com.example.securityPlayground.model.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    private final ResolutionRepository resolutionRepository;
    private final UserRepository userRepository;

    public TestController(ResolutionRepository resolutionRepository, UserRepository userRepository) {
        this.resolutionRepository = resolutionRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
    @GetMapping("/resolutions")
    public List<Resolution> getAllResolutions() {
        return this.resolutionRepository.findAll();
    }

    @GetMapping("/public")
    public String publicHello() {
        return "Public Hello";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloWorld(){
        return "Hello Admin world";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String helloManager(){
        return "Hello Manager world";
    }
}
