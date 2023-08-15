package com.example.demo.service.implementation;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
@Transactional
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;
    @Autowired
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
    @Override
    public void delete(Integer id) {
        if (id==null) {
            log.error("l'ID est null");
            return;
        }
        repository.deleteById(id);
    }

//    @Override
//    public Admin updateAdminbyId(Integer id, Admin admin) {
//        Optional<Admin> existingAdminOptional = repository.findById(id);
//        if (existingAdminOptional.isPresent()) {
//            Admin existingAdmin = existingAdminOptional.get();
//
//            // Update the properties of the existingAdmin object with the values from updatedAdmin
//            existingAdmin.setPassword(admin.getPassword());
//            existingAdmin.setEmail(admin.getEmail());
//            existingAdmin.setFullname(admin.getFullname());
//            existingAdmin.setLocalisation(admin.getLocalisation());
//            existingAdmin.setNumTel(admin.getNumTel());
//
//            return repository.updateAdmin(existingAdmin);
//        } else {
//            // Handle the case when the admin with the given ID is not found
//            throw new NotFoundException("Admin with ID " + id + " not found");
//        }
//    }

}
