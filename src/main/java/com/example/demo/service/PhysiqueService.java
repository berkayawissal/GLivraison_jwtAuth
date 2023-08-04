package com.example.demo.service;

import com.example.demo.entity.Physique;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhysiqueService {
    List<Physique> findAllPhysiques();

    Physique savePhysique(Physique physique);
    void delete(Integer id);

    Physique findById(Integer id);
}
