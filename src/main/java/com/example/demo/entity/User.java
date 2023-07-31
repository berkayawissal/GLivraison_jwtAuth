package com.example.demo.entity;

import lombok.*;
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
    private String fullname;
    private String password;
    private String email;
    private String address;
    private String localisation;
    private String numTel;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();


    public User(Integer id, String fullname, String password, String email, String address, String localisation, String numTel, Set<Role> roles) {

        this.id = id;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.localisation = localisation;
        this.numTel = numTel;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().toString()))
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
