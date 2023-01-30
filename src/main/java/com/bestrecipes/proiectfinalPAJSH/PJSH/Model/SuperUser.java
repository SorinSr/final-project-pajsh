package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;


@Entity
@Table(name = "super_user")
@Data
@PropertySource("classpath:superUSer.properties")
@Component("superUser")
public class SuperUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Value( "${bestRecipes.superUser.firstName}" )
    private String firstName;

    @Value("${bestRecipes.superUser.lastName}")
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
