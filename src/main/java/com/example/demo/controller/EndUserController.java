package com.example.demo.controller;

import com.example.demo.entity.EndUsers;
import com.example.demo.service.EndUsersService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/endUsers")
public class EndUserController {
    private final EndUsersService service;

    public EndUserController(EndUsersService service) {
        this.service = service;
    }
    @PostMapping
    public EndUsers saveEndUser(@Valid @RequestBody EndUsers endUsers) {
        System.out.println("saved");
        return (EndUsers) service.saveEndUser(endUsers);
    }
    @GetMapping("/endUsers")
    public List<EndUsers> findAllEndUsers (){
        return service.findAllEndUsers();
    }
}
