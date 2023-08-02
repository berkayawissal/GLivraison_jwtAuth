package com.example.demo.controller;

import com.example.demo.entity.Produit;
import com.example.demo.entity.User;
import com.example.demo.service.ProduitService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/auth/produit")
public class ProduitController {
    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Produit saveProduit(@Valid @RequestBody Produit produit) {
        System.out.println("saved");
        return (Produit) service.saveProduit(produit);
    }
    @GetMapping("/findAll")
    public List<Produit> findAllProduits (){
        return service.findAllProduits();
    }
    @GetMapping("/findById/{id}")
    public Produit findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}

