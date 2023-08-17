package com.example.demo.service.implementation;

import com.example.demo.entity.Distributeur;
import com.example.demo.repository.DistributeurRepository;
import com.example.demo.service.DistributeurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@Transactional
public class DistributeurServiceImpl implements DistributeurService {
    private final DistributeurRepository repository;

    @Autowired
    public DistributeurServiceImpl(DistributeurRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Distributeur> findAllDistributeurs() {
        return repository.findAll();
    }

    @Override
    public Distributeur saveDistributeur(Distributeur distributeurEntity) {
        return repository.save(distributeurEntity);
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
    public Distributeur findById(Integer id) {
        Optional<Distributeur> optional =repository.findById(id);
        return optional.orElse(null);
    }
}
