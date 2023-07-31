package com.example.demo.service.implementation;

import com.example.demo.entity.Physique;
import com.example.demo.repository.PhysiqueRepository;
import com.example.demo.service.PhysiqueService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhysiqueServiceImpl implements PhysiqueService {
    private PhysiqueRepository repository;

    public PhysiqueServiceImpl(PhysiqueRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Physique> findAllPhysiques() {
        return  repository.findAll();
    }

    @Override
    public Object savePhysique(Physique physique) {
        return  repository.save(physique);
    }
}
