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


    public EnLigne(String siteWeb) {
        this.siteWeb = siteWeb;
    }


}
