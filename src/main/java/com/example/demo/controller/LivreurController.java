package com.example.demo.controller;

import com.example.demo.entity.Livreur;
import com.example.demo.service.LivreurService;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/livreur")
@CrossOrigin(origins = "http://localhost:4200/livreurs")
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
    @PutMapping("/update/{id}")
    public ResponseEntity<Livreur> updateLivreur(@PathVariable("id") Integer id, @RequestBody Livreur updatedLivreur) {
        Livreur existingLivreur = service.findById(id);

        if (existingLivreur == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingLivreur.setFullname(updatedLivreur.getFullname());
        existingLivreur.setAddress(updatedLivreur.getAddress());
        existingLivreur.setLocalisation(updatedLivreur.getLocalisation());
        existingLivreur.setNumTel(updatedLivreur.getNumTel());

        Livreur savedLivreur = service.updateLivreur(existingLivreur);
        if (savedLivreur == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(savedLivreur, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
