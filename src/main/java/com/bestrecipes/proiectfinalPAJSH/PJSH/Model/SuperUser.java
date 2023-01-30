package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;


@Entity
@Table(name = "super_user")
@Data
@Component("superUser")
public class SuperUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Value("Uncle")
    private String firstName;

    @Value("Roger")
    private String lastName;

    @Value("uncle_roger@gmail.com")
    private String email;

    @Value("912345678")
    private String phoneNumber;

    @Value("35")
    private int age;

    @Value("Chef")
    private String occupation;

    @Value("true")
    private Boolean isCurrentAdminUser;
}
