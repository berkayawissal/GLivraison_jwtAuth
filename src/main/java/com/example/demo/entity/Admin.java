package com.example.demo.entity;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "admins")
public class Admin extends User {


}