package com.example.demo.repository;

import com.example.demo.entity.EnLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnLigneRepository extends JpaRepository<EnLigne,Integer> {
}
