package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "end_users")
public class EndUsers  {
public EndUsers(){

}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullname;
    private String password;
    private String email;
    private String address;
    private String localisation;
    private String numTel;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "point_de_vente_id")
    @JsonBackReference
    private PointDeVente pointDeVente;
    @OneToMany(mappedBy = "endUser",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Commande> commandes;
    @OneToMany(mappedBy = "endUsers",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Livreur> Livreurs;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonBackReference
    private User user;



    @Override
    public String toString() {
        return "EndUsers{" +
                ", pointDeVente=" + pointDeVente +
                ", commandes=" + commandes +
                ", Livreurs=" + Livreurs +
                '}';
    }
}

