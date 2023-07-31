package com.example.demo.controller;

import com.example.demo.entity.PointDeVente;
import com.example.demo.service.PointDeVenteService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pointDeVente")
public class PointDeVenteController {

    private final PointDeVenteService service;

    public PointDeVenteController(PointDeVenteService service) {
        this.service = service;
    }
    @PostMapping
    public PointDeVente savePointDeVente(@Valid @RequestBody PointDeVente pointDeVente) {
        System.out.println("saved");
        return (PointDeVente) service.savePointDeVente(pointDeVente);
    }
    @GetMapping("/pointDeVentes")
    public List<PointDeVente> findAllAdmins (){
        return service.findAllPointDeVentes();
    }
}
