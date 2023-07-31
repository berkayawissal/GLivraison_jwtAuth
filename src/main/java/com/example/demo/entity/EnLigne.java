package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EnLigne extends PointDeVente{
    private String siteWeb;
   public EnLigne (){

   }

    @Override
    public String toString() {
        return "EnLigne{" +
                "siteWeb='" + siteWeb + '\'' +
                '}';
    }

    public EnLigne(Integer id, String fullname, String password, String email, String address, String localisation, String numTel, Set<Role> roles) {
        super(id, fullname, password, email, address, localisation, numTel, roles);
    }

    public EnLigne(String siteWeb) {
        this.siteWeb = siteWeb;
    }


}
