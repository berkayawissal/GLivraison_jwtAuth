package com.example.demo.service.implementation;

import com.example.demo.entity.Livreur;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.LivreurRepository;
import com.example.demo.service.LivreurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@Transactional
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
    public Livreur saveLivreur(Livreur livreur) {
        return repository.save(livreur);
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
    public Livreur findById(Integer id) {
        Optional<Livreur> optional =repository.findById(id);
        return optional.orElse(null);
    }
}
