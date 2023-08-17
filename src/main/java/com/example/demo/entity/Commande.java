package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="Commandes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCommande;
    private double total;
    @Enumerated(EnumType.STRING)
    private EtatCommande etat;
    private LocalDate createdDate;
    private LocalDate dateLivree;
    private LocalDate dateRamassee;
    private Time tempsLivree;
    private String description;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "idLivreur")
    @JsonBackReference
    private Livreur livreurs;

    @ManyToMany(mappedBy = "commandes",fetch = FetchType.EAGER)
    private List<Produit> produits;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "endUserId")
    @JsonBackReference
    private EndUsers endUser;



    public Commande(double total, EtatCommande etat, String description) {
        this.total = total;
        this.etat = etat;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", total=" + total +
                ", etat=" + etat +
                ", createdDate=" + createdDate +
                ", dateLivree=" + dateLivree +
                ", dateRamassee=" + dateRamassee +
                ", tempsLivree=" + tempsLivree +
                ", description='" + description + '\'' +
                ", livreurs=" + livreurs +
                ", produits=" + produits +
                ", endUser=" + endUser +
                '}';
    }
}
