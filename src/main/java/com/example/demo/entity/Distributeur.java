package com.example.demo.entity;


import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name ="distributeur")
public class Distributeur extends User {
    @OneToMany(mappedBy = "distributeurs", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Produit> produits;

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Distributeur(Integer id, String fullname, String password, String email, String address, String localisation, String numTel, Set<Role> roles) {
        super(id, fullname, password, email, address, localisation, numTel, roles);
    }
}
