package com.example.demo.controller;

import com.example.demo.entity.Commande;
import com.example.demo.entity.EtatCommande;
import com.example.demo.service.CommandeService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Commande> saveCommande ( @RequestBody Commande commande){
        System.out.println("saved");
      // Commande commandeSaved = service.saveCommande(commande);
        return ResponseEntity.ok(service.saveCommande(commande));
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
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<Commande> findCommandeByEtat(@PathVariable(value = "etat") EtatCommande etat){
        return service.findCommandeByEtat(etat);
    }

    @GetMapping("/findDelivredCommands")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Integer> getDeliveredCommandId(@RequestParam("startDate") LocalDate startDate,
                                               @RequestParam("endDate") LocalDate endDate,
                                               @RequestParam("etat") EtatCommande etat) {
        return service.getDeliveredCommand(etat , startDate, endDate);
    }
    @GetMapping("/etats")
    public ResponseEntity<List<String>> getEtats() {
        List<String> etats = service.getEtats();
        return ResponseEntity.ok(etats);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
