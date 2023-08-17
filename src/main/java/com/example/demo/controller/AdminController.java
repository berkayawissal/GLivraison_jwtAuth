package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/auth/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService service;

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public Admin saveAdmin(@RequestBody Admin admin) {
        System.out.println("saved");
        return service.saveAdmin(admin);
    }
    @GetMapping("/AllAdmins")
    public List <Admin> findAllAdmins (){
        return service.findAllAdmins();
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
@GetMapping("/findById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Admin findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}


