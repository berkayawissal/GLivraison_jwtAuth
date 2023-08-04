package com.example.demo.repository;

import com.example.demo.entity.Admin;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
//    @Modifying
//    Admin updateAdmin(Admin admin);

}
