package com.example.demo.service;

import com.example.demo.entity.EndUsers;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EndUsersService {

    List<EndUsers> findAllEndUsers();

    Object saveEndUser(EndUsers endUsers);
    void delete(Integer id);

    EndUsers findById(Integer id);
}
