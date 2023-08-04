package com.example.demo.service.implementation;

import com.example.demo.entity.EndUsers;
import com.example.demo.repository.EndUsersRepository;
import com.example.demo.service.EndUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@Transactional
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
    public EndUsers saveEndUser(EndUsers endUsers) {
        return repository.save(endUsers);
    }
    @Override
    public void delete(Integer id) {
        if (id==null) {
            log.error("l'ID est null");
            return;
        }
        repository.deleteById(id);
    }

    @Override
    public EndUsers findById(Integer id) {
        Optional<EndUsers> optional =repository.findById(id);
        return optional.orElse(null);
    }
}
