package com.example.demo.service;

import com.example.demo.entity.EnLigne;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EnLigneService {

    List<EnLigne> findAllEnLignes();

    EnLigne saveEnLigne(EnLigne enLigne);
}
