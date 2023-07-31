package com.example.demo.service.implementation;

import com.example.demo.entity.Livreur;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.LivreurRepository;
import com.example.demo.service.LivreurService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivreurServiceIpml implements LivreurService {
    private LivreurRepository repository;

    public LivreurServiceIpml(LivreurRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Livreur> findAllLivreurs() {
        return repository.findAll();
    }

    @Override
    public Object saveLivreur(Livreur livreur) {
        return repository.save(livreur);
    }
}
