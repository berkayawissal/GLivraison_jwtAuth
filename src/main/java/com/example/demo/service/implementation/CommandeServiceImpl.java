package com.example.demo.service.implementation;

import com.example.demo.entity.Commande;
import com.example.demo.entity.EtatCommande;
import com.example.demo.repository.CommandeRepository;
import com.example.demo.service.CommandeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
@Transactional
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository repository;
    @Autowired
    public CommandeServiceImpl(CommandeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Commande> findAllCommandes() {
        return repository.findAll();
    }

    @Override
    public Commande saveCommande(Commande commande) {
        return repository.save(commande);
    }

    @Override
    public Optional<Commande> findCommandeById(Integer idCommande) {
        Optional<Commande> commandes = repository.findById(idCommande);
        return commandes.map(Optional::of).orElse(null);
    }
    @Override
    public Optional<Commande> findCommandeByEtat(EtatCommande etat) {
        Optional<Commande> commandes = repository.findByEtat(EtatCommande.LIVREE);
        if (commandes.isPresent()){
            return Optional.ofNullable(commandes.orElseThrow(() -> new RuntimeException("no delivered command found")));
    } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Integer> getDeliveredCommand(EtatCommande etat , LocalDate startDate, LocalDate endDate) {
        Optional<Commande>  commands  = repository.findByEtatDateBetween(startDate, endDate);
       // if (deliveredCommands.isPresent()){}
        return commands.stream()
                .filter(commande -> etat == null || commande.getEtat() == etat)
                .map(Commande::getIdCommande)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null) {
            log.error("l'ID est null");
            return;
        }
        repository.deleteById(id);
    }

    @Override
    public List<String> getEtats() {
        return Arrays.stream(EtatCommande.values())
                .map(EtatCommande::name)
                .collect(Collectors.toList());
    }


}
