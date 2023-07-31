package com.example.demo.service.implementation;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;

    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Admin> findAllAdmins() {

       return repository.findAll();
    }

    @Override
    public Admin saveAdmin(Admin dto) {
        return repository.save(dto);
    }

    @Override
    public Admin findById(Integer idAdmin) {
        Optional<Admin> optionalAdmin =repository.findById(idAdmin);
        return optionalAdmin.orElse(null);
    }


}
