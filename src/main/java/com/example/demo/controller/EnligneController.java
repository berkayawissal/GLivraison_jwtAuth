package com.example.demo.controller;


import com.example.demo.entity.EnLigne;
import com.example.demo.service.EnLigneService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/enLigne")
public class EnligneController {
    private final EnLigneService service;


    public EnligneController(EnLigneService service) {
        this.service = service;
    }
    @PostMapping
    public EnLigne saveEnLigne(@Valid @RequestBody EnLigne enLigne) {
        System.out.println("saved");
        return service.saveEnLigne(enLigne);
    }
    @GetMapping("/EnLignes")
    public List<EnLigne> findAllEnLignes (){
        return service.findAllEnLignes();
    }
}
