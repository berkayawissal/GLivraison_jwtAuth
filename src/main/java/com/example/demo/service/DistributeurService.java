package com.example.demo.service;

import com.example.demo.entity.Distributeur;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DistributeurService {
    List<Distributeur> findAllDistributeurs();

    Distributeur saveDistributeur(Distributeur distributeurEntity);
    void delete(Integer id);

    Distributeur findById(Integer id);
}
