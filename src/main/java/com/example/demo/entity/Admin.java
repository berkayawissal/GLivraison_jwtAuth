package com.example.demo.entity;

import antlr.build.ANTLR;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "admins")
@AllArgsConstructor
public class Admin extends User {
    public Admin(Integer id, String fullname, String password, String email, String address, String localisation, String numTel, Set<Role> roles) {
        super(id, fullname, password, email, address, localisation, numTel, roles);
    }
}