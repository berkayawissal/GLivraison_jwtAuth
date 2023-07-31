package com.example.demo.controller;

import com.example.demo.entity.Physique;
import com.example.demo.service.PhysiqueService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/physique")
public class PhysiqueController {
    private final PhysiqueService service;

    public PhysiqueController(PhysiqueService service) {
        this.service = service;
    }
    @PostMapping
    public Physique savePhysique(@Valid @RequestBody Physique physique) {
        System.out.println("saved");
        return (Physique) service.savePhysique(physique);
    }
    @GetMapping("/physiques")
    public List<Physique> findAllPhysiques (){
        return service.findAllPhysiques();
    }
}
