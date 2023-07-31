package com.example.demo.controller;

import com.example.demo.entity.Produit;
import com.example.demo.service.ProduitService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @PostMapping
    public Produit saveProduit(@Valid @RequestBody Produit produit) {
        System.out.println("saved");
        return (Produit) service.saveProduit(produit);
    }
    @GetMapping("/produit")
    public List<Produit> findAllProduits (){
        return service.findAllProduits();
    }
}

