package com.example.demo.controller;

import com.example.demo.entity.Physique;
import com.example.demo.entity.User;
import com.example.demo.service.PhysiqueService;
import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/auth/physique")
public class PhysiqueController {
    private final PhysiqueService service;

    public PhysiqueController(PhysiqueService service) {
        this.service = service;
    }
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public Physique savePhysique(@Valid @RequestBody Physique physique) {
        System.out.println("saved");
        return  service.savePhysique(physique);
    }
    @GetMapping("/findAll")
    public List<Physique> findAllPhysiques (){
        return service.findAllPhysiques();
    }
    @GetMapping("/findById/{id}")
    public Physique findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
