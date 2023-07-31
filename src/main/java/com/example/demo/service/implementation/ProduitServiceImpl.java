package com.example.demo.service.implementation;

import com.example.demo.entity.Produit;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.service.ProduitService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProduitServiceImpl implements ProduitService {
    private ProduitRepository repository;

    public ProduitServiceImpl(ProduitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Produit> findAllProduits() {
        return repository.findAll();
    }

    @Override
    public Object saveProduit(Produit produit) {
        return repository.save(produit);
    }
}
