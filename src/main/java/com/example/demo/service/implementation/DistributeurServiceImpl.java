package com.example.demo.service.implementation;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Distributeur;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.DistributeurRepository;
import com.example.demo.service.DistributeurService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
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
    public Object saveDistributeur(Distributeur distributeurEntity) {
        return repository.save(distributeurEntity);
    }
}
