package com.example.demo.service.implementation;

import com.example.demo.entity.Admin;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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
        List<Admin> admins = List.of(new Admin(1,"password","email@admin1","admin"), new Admin(2,"password","email@admin2", "admin"));
        when(repository.findAll()).thenReturn(admins);
        assertEquals(2,  underTest.findAllAdmins().size());
    }

    @Test
    void saveAdmin() {
        Admin admin = new Admin(1,"password","email@admin1", "admin");
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


}