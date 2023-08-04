package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name ="users")
public class User  implements UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String password;
    private String email;
    private String fullname;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Token> tokens;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Set<Role> roles = new HashSet<>();

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "idAdmin")
    @JsonBackReference
    private Admin admin;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Distributeur> distributeurs;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<EndUsers> endUsers;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<PointDeVente> pointDeVentes;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Livreur> Livreurs;

    public User(Integer id ,String password, String email, Set<Role> roles) {

        this.id = id;

        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public User(Integer id, String password, String email, String fullname, List<Token> tokens, Set<Role> roles, Admin idAdmin, List<Distributeur> distributeurs, List<EndUsers> endUsers, List<PointDeVente> pointDeVentes, List<Livreur> livreurs) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.tokens = tokens;
        this.roles = roles;
        this.admin = idAdmin;
        this.distributeurs = distributeurs;
        this.endUsers = endUsers;
        this.pointDeVentes = pointDeVentes;
        this.Livreurs = livreurs;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
