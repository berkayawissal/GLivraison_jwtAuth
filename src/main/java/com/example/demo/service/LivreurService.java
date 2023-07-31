package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Livreur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LivreurService {
    List<Livreur> findAllLivreurs();

    Object saveLivreur(Livreur livreur);
}
