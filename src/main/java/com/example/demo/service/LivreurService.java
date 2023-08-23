package com.example.demo.service;

import com.example.demo.entity.Livreur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LivreurService {
    List<Livreur> findAllLivreurs();

    Livreur saveLivreur(Livreur livreur);
    void delete(Integer id);

    Livreur findById(Integer id);
    Livreur updateLivreur(Livreur livreur);
}
