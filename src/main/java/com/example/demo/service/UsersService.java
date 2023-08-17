package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersService {
    List<User> findAllUsers();

    User saveUser(User usersDto);

    Optional<User> findByLogin(String email);
    User findById(Integer id);

    Optional<User> findByEmail(String email);

    void delete(Integer id);
}
