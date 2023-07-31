package com.example.demo.repository;

import com.example.demo.entity.Physique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysiqueRepository extends JpaRepository<Physique, Integer> {
}
