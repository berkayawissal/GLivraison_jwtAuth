package com.example.demo.service.implementation;

import com.example.demo.entity.EndUsers;
import com.example.demo.repository.EndUsersRepository;
import com.example.demo.service.EndUsersService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EndUsersServiceImpl implements EndUsersService {

    private EndUsersRepository repository;

    public EndUsersServiceImpl(EndUsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EndUsers> findAllEndUsers() {
        return repository.findAll();
    }

    @Override
    public Object saveEndUser(EndUsers endUsers) {
        return repository.save(endUsers);
    }
}
