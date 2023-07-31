package com.example.demo.service.implementation;

import com.example.demo.entity.User;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Slf4j
@Component
public class UsersServiceImpl implements UsersService {
    private final UserRepository repository;
    public UsersServiceImpl(UserRepository repository) {
        this.repository = repository;
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
            log.error("l'ID Client est null");
            return;
        }
        repository.deleteById(id);
    }

}
