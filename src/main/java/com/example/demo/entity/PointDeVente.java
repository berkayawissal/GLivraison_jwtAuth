package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@Table (name ="PointDeVente")
public class PointDeVente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPointDeVente;
    private String fullname;
    private String password;
    private String email;
    private String address;
    private String localisation;
    private String numTel;


    public PointDeVente() {
    }
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonBackReference
    private User user;
    @OneToMany(mappedBy = "pointDeVente",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<EndUsers> endUsers;

    @OneToMany(mappedBy = "pointDeVente",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
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



    @Override
    public String toString() {
        return "PointDeVente{" +
                "endUsers=" + endUsers +
                ", produits=" + produits +
                '}';
    }
}

