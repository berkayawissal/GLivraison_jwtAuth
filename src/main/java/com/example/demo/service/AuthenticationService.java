package com.example.demo.service;

import com.example.demo.auth.AuthenticationRequest;
import com.example.demo.auth.AuthenticationResponse;
import com.example.demo.auth.RegistrationRequest;
import com.example.demo.config.JwtService;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationService {
  private final RoleRepository roleRepository;
  private final UserRepository repository;
  private final AdminRepository adminRepository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final LivreurRepository livreurRepository;

  public AuthenticationResponse register(RegistrationRequest request) {
	 //
    Set<String> strRoles = request.getRole();
      //System.err.println(strRoles[]);
    Set<Role> roles = new HashSet<>();
    //todo if role = "ADMIN" => adminRepository.save(request) :: dans le table admin
    //todo if role = "Livreur" => livreurRepository.save(request) :: dans le table livreur
      if (strRoles == null) {
          Role userRole = roleRepository.findByName("USER")
                  .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
      } else {
          strRoles.forEach(role -> {

                  Role adminRole = roleRepository.findByName(role)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);

          });
      }
    var  user = User.builder()
            .fullname(request.getFullname())
            .numTel(request.getNumTel())
            .localisation(request.getLocalisation())
            .address(request.getAddress())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
    user.setRoles(roles);
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    saveUserToken(savedUser, jwtToken);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
            .refreshToken(refreshToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
            .refreshToken(refreshToken)
        .build();
  }

  private void saveUserToken(User user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {
      var user = this.repository.findByEmail(userEmail)
              .orElseThrow();
      if (jwtService.isTokenValid(refreshToken, user)) {
        var accessToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        var authResponse = AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }
}
/*if (strRoles != null) {
    var  user = User.builder()
            .fullname(request.getFullname())
            .numTel(request.getNumTel())
            .localisation(request.getLocalisation())
            .address(request.getAddress())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
    user.setRoles(strRoles);
    switch (strRoles) {
      case "ADMIN":
        var adminSaved = adminRepository.saveAdmin((Admin) user);
        var jwtTokenAdmin = jwtService.generateToken(user);
        var refreshTokenAdmin = jwtService.generateRefreshToken(user);
        saveUserToken(adminSaved, jwtTokenAdmin);
        return AuthenticationResponse.builder()
                .accessToken(jwtTokenAdmin)
                .refreshToken(refreshTokenAdmin)
                .build();
      case "LIVREUR":
        var livreurSaved = livreurRepository.saveLivreur((Livreur) user);
        var jwtTokenLivreur = jwtService.generateToken(user);
        var refreshTokenLivreur = jwtService.generateRefreshToken(user);
        saveUserToken(livreurSaved, jwtTokenLivreur);
        return AuthenticationResponse.builder()
                .accessToken(jwtTokenLivreur)
                .refreshToken(refreshTokenLivreur)
                .build();
      default:
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
  }*/
 