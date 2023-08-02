package com.example.demo.controller;


import com.example.demo.entity.EnLigne;
import com.example.demo.entity.User;
import com.example.demo.service.EnLigneService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/auth/enLigne")
public class EnligneController {
    private final EnLigneService service;


    public EnligneController(EnLigneService service) {
        this.service = service;
    }
    @PostMapping("/save")
    public EnLigne saveEnLigne(@Valid @RequestBody EnLigne enLigne) {
        System.out.println("saved");
        return service.saveEnLigne(enLigne);
    }
    @GetMapping("/findAll")
    public List<EnLigne> findAllEnLignes (){
        return service.findAllEnLignes();
    }
    @GetMapping("/findById/{id}")
    public EnLigne findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
