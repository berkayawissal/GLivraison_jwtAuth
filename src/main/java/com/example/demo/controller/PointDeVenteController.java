package com.example.demo.controller;

import com.example.demo.entity.PointDeVente;
import com.example.demo.entity.User;
import com.example.demo.service.PointDeVenteService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/auth/pointDeVente")
public class PointDeVenteController {

    private final PointDeVenteService service;

    public PointDeVenteController(PointDeVenteService service) {
        this.service = service;
    }
    @PostMapping("/save")
    public PointDeVente savePointDeVente(@Valid @RequestBody PointDeVente pointDeVente) {
        System.out.println("saved");
        return (PointDeVente) service.savePointDeVente(pointDeVente);
    }
    @GetMapping("/findAll")
    public List<PointDeVente> findAllAdmins (){
        return service.findAllPointDeVentes();
    }
    @GetMapping("/findById/{id}")
    public PointDeVente findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
