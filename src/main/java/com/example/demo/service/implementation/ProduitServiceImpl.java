package com.example.demo.service.implementation;

import com.example.demo.entity.Produit;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.service.ProduitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
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
    public Produit saveProduit(Produit produit) {
        return repository.save(produit);
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
    public Produit findById(Integer id) {
        Optional<Produit> optional =repository.findById(id);
        return optional.orElse(null);
    }

}
