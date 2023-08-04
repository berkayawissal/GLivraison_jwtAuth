package com.example.demo.entity;

import antlr.build.ANTLR;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "admins")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Admin  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String password;
    private String email;
    private String fullname;
    @OneToMany(mappedBy = "admin",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<User> users;

    public Admin(Integer id, String password, String email, String fullname) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", users=" + users +
                '}';
    }
}