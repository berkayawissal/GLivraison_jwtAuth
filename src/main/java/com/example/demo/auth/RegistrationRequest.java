package com.example.demo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import com.example.demo.entity.User;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {

    private Set<String> roles;
    private String email;
    private String password;
    private String fullname;

    // methode de mappage
    public static User toEntity(RegistrationRequest request) {
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .fullname(request.getFullname())
                .build();
    }
}