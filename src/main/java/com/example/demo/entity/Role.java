package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Enumerated(EnumType.STRING)
    private ERole name;

	public Role(ERole eRole) {
	}

	/* @ManyToMany(fetch = FetchType.EAGER)
     private Set<User> users=new HashSet<>();*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ERole getName() {
		return name;
	}
	public void setName(String name) {
		this.name = ERole.valueOf(name);
	}
    

}
