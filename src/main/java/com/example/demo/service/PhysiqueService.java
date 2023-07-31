package com.example.demo.service;

import com.example.demo.entity.Physique;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhysiqueService {
    List<Physique> findAllPhysiques();

    Object savePhysique(Physique physique);
}
