package com.example.demo.service.implementation;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Role;
import com.example.demo.entity.Token;
import com.example.demo.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {
    private AdminServiceImpl underTest;

    @Mock
    private AdminRepository repository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new AdminServiceImpl(repository);
    }
                                                //id, fullname, password,email,address,localisation, numTel, List<Token> tokens, Set<Role> roles
    @Test
    void findAllAdmins() {
        List<Admin> admins = List.of(new Admin(1,"admin1","password","email@admin1","address","localisation1","15452", (Set<Role>) new Role("ADMIN")), new Admin(2,"admin2","password","email@admin2","address","localisation2","4512", (Set<Role>) new Role("ADMIN")));
        when(repository.findAll()).thenReturn(admins);
        assertEquals(2,  underTest.findAllAdmins().size());
    }

    @Test
    void saveAdmin() {
        Admin admin = new Admin(1,"admin1","password","email@admin1","address","localisation1","15452", (Set<Role>) new Role("ADMIN"));
        underTest.saveAdmin(admin);
        ArgumentCaptor<Admin> adminArgumentCaptor = ArgumentCaptor.forClass(Admin.class);
        verify(repository).save(adminArgumentCaptor.capture());
        Admin capturedAdmin = adminArgumentCaptor.getValue();
        assertThat(capturedAdmin).isEqualTo(admin);

    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }

    @Test
    void updateAdminbyId() {
        Admin admin = new Admin(1,"admin1","password","email@admin1","address","localisation1","15452", (Set<Role>) new Role("ADMIN"));
        given(repository.findById(admin.getId())).willReturn(Optional.of(admin));
        given(repository.updateAdmin(admin)).willReturn(admin);
        ArgumentCaptor<Admin> captor = ArgumentCaptor.forClass(Admin.class);
        int result= underTest.updateAdminbyId(admin.getId(),admin).getId();
        verify(repository).findById(admin.getId());
        verify(repository).updateAdmin(captor.capture());
        Admin adminCap= captor.getValue();

        assertEquals(result , 1);
    }


}