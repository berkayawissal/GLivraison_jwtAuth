package com.example.demo.controller;


import com.example.demo.auth.AuthenticationRequest;
import com.example.demo.auth.AuthenticationResponse;
import com.example.demo.auth.RegistrationRequest;
import com.example.demo.entity.User;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.UsersService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/user")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService service;
    private final AuthenticationService serviceAuth;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegistrationRequest request
    ) {
        return ResponseEntity.ok(serviceAuth.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(serviceAuth.authenticate(request));
    }
///api/auth/user/allUsers
     @PostMapping("/save")
    public User saveUser(@RequestBody User user) {

        return service.saveUser(user);
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

