package com.example.demo.service.implementation;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Distributeur;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.DistributeurRepository;
import com.example.demo.service.DistributeurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class DistributeurServiceImpl implements DistributeurService {
    private DistributeurRepository repository;
    public DistributeurServiceImpl(DistributeurRepository repository){
        this.repository=repository;
    }

    public DistributeurServiceImpl() {
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
