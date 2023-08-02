package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table (name ="livreur")
public class Livreur extends User{
    public Livreur(){

    }
    @OneToMany(mappedBy = "livreurs", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Commande> commandes;
    @ManyToOne( cascade=CascadeType.PERSIST)
    @JoinColumn(name = "idEndUser")
    @JsonBackReference
    private EndUsers endUsers;
    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public EndUsers getEndUsers() {
        return endUsers;
    }

    public void setEndUsers(EndUsers endUsers) {
        this.endUsers = endUsers;
    }

    public Livreur(Integer id, String fullname, String password, String email, String address, String localisation, String numTel, Set<Role> roles) {
        super(id, fullname, password, email, address, localisation, numTel, roles);
    }

    @Override
    public String toString() {
        return "Livreur{" +
                "commandes=" + commandes +
                ", endUsers=" + endUsers +
                '}';
    }
}
