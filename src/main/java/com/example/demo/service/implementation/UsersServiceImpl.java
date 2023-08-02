package com.example.demo.service.implementation;

import
        com.example.demo.entity.Token;
import com.example.demo.entity.User;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Slf4j
@Component
@Transactional
public class UsersServiceImpl implements UsersService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    public UsersServiceImpl(UserRepository repository, TokenRepository tokenRepository) {
        this.repository = repository;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findByLogin(String email) {
        Optional<User> user =repository.findByEmail(email);
        if (user.isPresent()) {
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public User findById(Integer id) {
        Optional<User> users =repository.findById(id);
        return users.orElse(null);
    }


    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user =repository.findByEmail(email);
        if (user.isPresent()) {
            return user;
        }
        else {
            return null;
        }
    }
    @Override
    public User getUserByFullname(String name) {
        User user = repository.getUserByFullname(name);
        if(user == null){
            throw new AdminNotFoundException("Invalid id and password");
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        if (id==null) {
            log.error("l'ID est null");
            return;
        }else {
            Optional<User> userOptional = repository.findById(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                List<Token> tokenOptional = tokenRepository.findAllTokenByUser(user.getId());
                if (tokenOptional.isEmpty()) {
                    log.error("Token n'existe pas.");
                }else {
                    tokenOptional.forEach(tokenD -> {
                        tokenD.getUser().getTokens();

                    });
                    tokenRepository.deleteAll(tokenOptional);
                    // Delete the associated tokens from the "Token" table
                }
                    // Delete the user from the "User" table
                repository.deleteById(id);
            } else {
                log.error("User avec l'ID " + id + " n'existe pas.");
            }

        }
    }

}
