package com.example.demo.controller;

import com.example.demo.entity.Commande;
import com.example.demo.entity.EtatCommande;
import com.example.demo.entity.User;
import com.example.demo.service.CommandeService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/commande")
public class CommandeController {
    private final CommandeService service;

    public CommandeController(CommandeService service) {
        this.service = service;
    }
    @PostMapping("/save")
    public Commande saveCommande (@Valid @RequestBody Commande commande){
        System.out.println("saved");
        return service.saveCommande(commande);
    }
    @GetMapping("/findAll")
    public List<Commande> findAllCommandes(){
        return service.findAllCommandes();
    }

    @GetMapping("/findById/{id}")
    public Optional<Commande> findCommandeById (@PathVariable(value = "idCommande") Integer idCommande){
        return  service.findCommandeById(idCommande);
    }

    @GetMapping("/findByEtat/{etat}")
    public Optional<Commande> findCommandeByEtat(@PathVariable(value = "etat") EtatCommande etat){
        return service.findCommandeByEtat(etat);
    }

    @GetMapping("/findDelivredCommands")
    public List<Integer> getDeliveredCommandId(@RequestParam("startDate") LocalDate startDate,
                                               @RequestParam("endDate") LocalDate endDate,
                                               @RequestParam("etat") EtatCommande etat) {
        return service.getDeliveredCommand(etat , startDate, endDate);
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
