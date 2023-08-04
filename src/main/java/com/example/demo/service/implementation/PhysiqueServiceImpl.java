package com.example.demo.service.implementation;

import com.example.demo.entity.Physique;
import com.example.demo.repository.PhysiqueRepository;
import com.example.demo.service.PhysiqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@Transactional
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
    public Physique savePhysique(Physique physique) {
        return  repository.save(physique);
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
    public Physique findById(Integer id) {
        Optional<Physique> optional =repository.findById(id);
        return optional.orElse(null);
    }
}
