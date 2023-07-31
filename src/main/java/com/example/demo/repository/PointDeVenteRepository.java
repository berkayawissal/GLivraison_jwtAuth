package com.example.demo.repository;

import com.example.demo.entity.PointDeVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointDeVenteRepository extends JpaRepository<PointDeVente, Integer> {
}
