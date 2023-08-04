package com.example.demo.service.implementation;

import com.example.demo.entity.PointDeVente;
import com.example.demo.repository.PointDeVenteRepository;
import com.example.demo.service.PointDeVenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@Transactional
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
    public PointDeVente savePointDeVente(PointDeVente pointDeVente) {
        return repository.save(pointDeVente);
    }
    @Override
    public void delete(Integer id) {
        if (id==null) {
            log.error("l'ID est null");
            return;
        }
        repository.deleteById(id);
    }

    @Override
    public PointDeVente findById(Integer id) {
        Optional<PointDeVente> optional =repository.findById(id);
        return optional.orElse(null);
    }

}
