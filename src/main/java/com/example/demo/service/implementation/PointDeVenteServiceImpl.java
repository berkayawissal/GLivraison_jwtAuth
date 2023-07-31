package com.example.demo.service.implementation;

import com.example.demo.entity.PointDeVente;
import com.example.demo.repository.PointDeVenteRepository;
import com.example.demo.service.PointDeVenteService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PointDeVenteServiceImpl implements PointDeVenteService {

    private PointDeVenteRepository repository;

    public PointDeVenteServiceImpl(PointDeVenteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PointDeVente> findAllPointDeVentes() {
        return repository.findAll();
    }

    @Override
    public Object savePointDeVente(PointDeVente pointDeVente) {
        return repository.save(pointDeVente);
    }
}
