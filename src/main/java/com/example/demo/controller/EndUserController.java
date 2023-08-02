package com.example.demo.controller;

import com.example.demo.entity.EndUsers;
import com.example.demo.entity.User;
import com.example.demo.service.EndUsersService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/auth/endUser")
public class EndUserController {
    private final EndUsersService service;

    public EndUserController(EndUsersService service) {
        this.service = service;
    }
    @PostMapping("/save")
    public EndUsers saveEndUser(@Valid @RequestBody EndUsers endUsers) {
        System.out.println("saved");
        return (EndUsers) service.saveEndUser(endUsers);
    }
    @GetMapping("/findAll")
    public List<EndUsers> findAllEndUsers (){
        return service.findAllEndUsers();
    }
    @GetMapping("/findById/{id}")
    public EndUsers findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
