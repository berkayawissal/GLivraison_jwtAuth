package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admins")
@AllArgsConstructor
public class AdminController {

    private final AdminService service;

    @PostMapping("/save")
    public Admin saveAdmin(@RequestBody Admin admin) {
        System.out.println("saved");
        return service.saveAdmin(admin);
    }
    @GetMapping("/AllAdmins")
    public List <Admin> findAllAdmins (){
        return service.findAllAdmins();
    }

//    @PutMapping("update/{id}")
//    public Admin updateAdmin(@PathVariable Integer id, @RequestBody Admin admin) {
//        admin.setLogin(admin.getLogin());
//        admin.setRole(admin.getRole());
//        admin.setPassword(admin.getRole());
//        return (Admin) service.updateAdminbyId(id, admin);
//    }
}


