package com.example.demo.entity;


import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table (name ="distributeur")
public class Distributeur  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullname;
    private String password;
    private String email;
    private Boolean etat;
    private String address;
    private String localisation;
    private String numTel;

    @OneToMany(mappedBy = "distributeurs", fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Produit> produits;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonBackReference
    private User user;
    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "Distributeur{" +
                "idDistributeur=" + id +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", localisation='" + localisation + '\'' +
                ", numTel='" + numTel + '\'' +
                ", produits=" + produits +
                ", user=" + user +
                '}';
    }
}
