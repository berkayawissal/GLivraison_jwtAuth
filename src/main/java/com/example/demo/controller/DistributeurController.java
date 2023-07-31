package com.example.demo.controller;

import com.example.demo.entity.Distributeur;
import com.example.demo.service.DistributeurService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/distributeurs")
public class DistributeurController {
    private final DistributeurService service;

    public DistributeurController(DistributeurService service) {
        this.service = service;
    }

    @PostMapping
    public Distributeur saveDistributeur(@Valid @RequestBody Distributeur distributeur) {
        System.out.println("saved");
        return (Distributeur) service.saveDistributeur(distributeur);
    }
    @GetMapping("/distributeurs")
    public List<Distributeur> findAllDistributeurs (){
        return service.findAllDistributeurs();
    }
}
