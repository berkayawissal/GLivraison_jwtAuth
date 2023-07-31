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

    private Set<String> role;
    private String email;
    private String password;
    private String fullname;
    private String address;
    private String localisation;
    private String numTel;


    // methode de mappage
    public static User toEntity(RegistrationRequest request) {
        return User.builder()
                .fullname(request.getFullname())
                .email(request.getEmail())
                .password(request.getPassword())
                .address(request.getAddress())
                .localisation(request.getLocalisation())
                .numTel(request.getNumTel())
                .build();
    }
}