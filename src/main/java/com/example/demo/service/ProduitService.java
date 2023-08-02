package com.example.demo.service;

import com.example.demo.entity.Produit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProduitService {
    List<Produit> findAllProduits();

    Object saveProduit(Produit produit);

    void delete(Integer id);

    Produit findById(Integer id);
}
