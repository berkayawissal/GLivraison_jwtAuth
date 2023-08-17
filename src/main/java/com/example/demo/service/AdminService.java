package com.example.demo.service;

import com.example.demo.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {

    List<Admin> findAllAdmins();

    Admin saveAdmin(Admin dto);

    Admin findById(Integer idAdmin);
    void delete(Integer id);

//    Admin updateAdminbyId(Integer id, Admin admin);

}

