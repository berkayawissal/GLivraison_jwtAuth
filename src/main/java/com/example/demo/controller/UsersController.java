package com.example.demo.controller;


import com.example.demo.auth.AuthenticationRequest;
import com.example.demo.auth.AuthenticationResponse;
import com.example.demo.auth.RegistrationRequest;
import com.example.demo.entity.User;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.UsersService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/user")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService service;
    private final PasswordEncoder passwordEncoder;
    @PreAuthorize("hasAuthority('ADMIN')")
     @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody User userRequest) {
        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());

        // Create a new User entity
        User user = new User();
        user.setFullname(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setAddress(userRequest.getAddress());
        user.setLocalisation(userRequest.getLocalisation());
        user.setPassword(encodedPassword);
        user.setNumTel(userRequest.getNumTel());
        user.setRoles(userRequest.getRoles());
        //user.setAuthorities(Collections.singleton(Authorities.USER)); // Assuming regular users have "USER" authority

        // Save the user
        service.saveUser(user);

        return ResponseEntity.ok("User registered successfully.");
    }
    @GetMapping("/allUsers")
    public List<User> findAllUsers(){
        return service.findAllUsers();
    }
    @GetMapping("/findByLogin/{email}")
    public Optional<User> findByLogin(@PathVariable String email) {
        return service.findByEmail(email);
    }
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}

