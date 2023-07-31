package com.example.demo.service.implementation;

import com.example.demo.entity.EnLigne;
import com.example.demo.repository.EnLigneRepository;
import com.example.demo.service.EnLigneService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EnLigneServiceImpl implements EnLigneService {

    private EnLigneRepository repository;

    public EnLigneServiceImpl(EnLigneRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<EnLigne> findAllEnLignes() {

            return repository.findAll();
    }

    @Override
    public EnLigne saveEnLigne (EnLigne enLigne) {
            return repository.save(enLigne);
    }
}
