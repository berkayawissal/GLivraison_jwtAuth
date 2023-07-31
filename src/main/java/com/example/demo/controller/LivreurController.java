package com.example.demo.controller;

import com.example.demo.entity.Livreur;
import com.example.demo.service.LivreurService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livreurs")
public class LivreurController {

    private final LivreurService service;

    public LivreurController(LivreurService service) {
        this.service = service;
    }
    @PostMapping
    public Livreur saveLivreur(@Valid @RequestBody Livreur livreur) {
        System.out.println("saved");
        return (Livreur) service.saveLivreur(livreur);
    }
    @GetMapping("/livreurs")
    public List<Livreur> findAllLivreurs (){
        return service.findAllLivreurs();
    }
}
