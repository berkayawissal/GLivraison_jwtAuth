package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
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
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
//    @PutMapping("/update/{id}")
//    public Admin updateAdmin(@PathVariable Integer id, @RequestBody Admin admin) {
//        admin.setEmail(admin.getEmail());
//        admin.setPassword(admin.getPassword());
//        return service.updateAdminbyId(id, admin);
//    }
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}


