package com.example.demo.repository;

import com.example.demo.entity.Commande;
import com.example.demo.entity.EtatCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    @Query("SELECT c FROM Commande c WHERE c.etat = :etat")
    Optional<Commande> findByEtat(@Param("etat") EtatCommande etat);
    List<Commande> findByCreatedDate(LocalDate createdDateTime);

    List<Commande> findByDateLivree(LocalDate createdDateTime);
    @Query("SELECT c.idCommande FROM Commande c WHERE (c.dateLivree BETWEEN :startDate AND :endDate)")
    Optional<Commande> findByEtatDateBetween(@Param("startDate") LocalDate startDate,
                                         @Param("endDate") LocalDate endDate);
}
