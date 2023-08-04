package com.example.demo.controller;

import com.example.demo.entity.Livreur;
import com.example.demo.entity.User;
import com.example.demo.service.LivreurService;
import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/livreur")
public class LivreurController {

    private final LivreurService service;

    public LivreurController(LivreurService service) {
        this.service = service;
    }
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public Livreur saveLivreur(@Valid @RequestBody Livreur livreur) {
        System.out.println("saved");
        return service.saveLivreur(livreur);
    }
    @GetMapping("/findAll")
    public List<Livreur> findAllLivreurs (){
        return service.findAllLivreurs();
    }
    @GetMapping("/findById/{id}")
    public Livreur findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
