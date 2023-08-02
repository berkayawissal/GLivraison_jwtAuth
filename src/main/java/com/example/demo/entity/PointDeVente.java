package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
@Table (name ="PointDeVente")
public class PointDeVente extends User {


    public PointDeVente() {
    }
    @OneToMany(mappedBy = "pointDeVente", cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<EndUsers> endUsers;

    @OneToMany(mappedBy = "pointDeVente",cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Produit> produits;

    public List<EndUsers> getEndUsers() {
        return endUsers;
    }

    public void setEndUsers(List<EndUsers> endUsers) {
        this.endUsers = endUsers;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public PointDeVente(Integer id, String fullname, String password, String email, String address, String localisation, String numTel, Set<Role> roles) {
        super(id, fullname, password, email, address, localisation, numTel, roles);
    }

    @Override
    public String toString() {
        return "PointDeVente{" +
                "endUsers=" + endUsers +
                ", produits=" + produits +
                '}';
    }
}

