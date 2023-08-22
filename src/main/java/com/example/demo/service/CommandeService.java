package com.example.demo.service;

import com.example.demo.entity.Commande;
import com.example.demo.entity.EtatCommande;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface CommandeService {
    List<Commande> findAllCommandes();

    Commande saveCommande(Commande dto);

    Optional<Commande> findCommandeById(Integer idCommande);

    Optional<Commande> findCommandeByEtat(EtatCommande etat);

    Optional<Commande> getDeliveredCommand(LocalDate startDate, LocalDate endDate,EtatCommande etat );
    void delete(Integer id);

    List<String> getEtats();
}
