package com.example.demo.service;


import com.example.demo.entity.PointDeVente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PointDeVenteService {
    List<PointDeVente> findAllPointDeVentes();

    PointDeVente savePointDeVente(PointDeVente pointDeVente);
    void delete(Integer id);

    PointDeVente findById(Integer id);
}
