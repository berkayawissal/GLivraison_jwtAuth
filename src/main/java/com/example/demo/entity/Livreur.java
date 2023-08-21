package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Value;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table (name ="livreur")
public class Livreur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullname;
    private String password;
    private String email;
//    @DefaultValue("true")
    private Boolean etat;
    private String address;
    private String localisation;
    private String numTel;

    public Livreur(){

    }
    @OneToMany(mappedBy = "livreurs",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Commande> commandes;
    @ManyToOne( cascade=CascadeType.PERSIST)
    @JoinColumn(name = "idEndUser")
    @JsonBackReference
    private EndUsers endUsers;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonBackReference
    private User user;
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


    @Override
    public String toString() {
        return "Livreur{" +
                "commandes=" + commandes +
                ", endUsers=" + endUsers +
                '}';
    }
}
