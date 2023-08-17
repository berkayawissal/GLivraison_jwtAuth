package com.example.demo.service.implementation;

import com.example.demo.entity.Livreur;
import com.example.demo.repository.LivreurRepository;
import com.example.demo.service.LivreurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@Transactional
public class LivreurServiceIpml implements LivreurService {
    private final LivreurRepository repository;
    @Autowired
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
    @Override
    public Livreur updateLivreur(Livreur updatedLivreur) {
        Integer id = updatedLivreur.getId();
        if (id == null) {
            log.error("L'ID est null");
            return null;
        }

        Optional<Livreur> existingLivreurOptional = repository.findById(id);
        if (existingLivreurOptional.isEmpty()) {
            log.error("Livreur avec l'ID {} non trouvé", id);
            return null;
        }

        Livreur existingLivreur = existingLivreurOptional.get();

        existingLivreur.setFullname(updatedLivreur.getFullname());
        existingLivreur.setAddress(updatedLivreur.getAddress());
        existingLivreur.setLocalisation(updatedLivreur.getLocalisation());
        existingLivreur.setNumTel(updatedLivreur.getNumTel());

    return repository.save(existingLivreur);
    }
}
